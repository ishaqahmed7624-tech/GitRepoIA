package rsWork.mavenRsFramewrk.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rsWork.mavenRsFramewrk.CartPage;
import rsWork.mavenRsFramewrk.ProductCatalog;
import rsWork.mavenRsFramewrk.TestComponents.BaseTest;

public class NegativeTest extends BaseTest {
//this is automated test created by GithubCopiolot.
    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][] {
            {"invalid.user@example.com", "wrongpassword"},
            {"jaunelia@gmail.com", "WrongPassword@123"},
            {"ishaqahmed1548@gmail.com", "Ahmed@1223"}
        };
    }

    @Test(groups = {"Negative", "ErrorHandling"}, dataProvider = "invalidLoginData")
    public void invalidLoginShouldDisplayErrorMessage(String email, String password) {
        landingpage.loginAct(email, password);

        String errorMessage = landingpage.getErrorMessage();
        Assert.assertNotNull(errorMessage, "Error message should not be null for invalid login.");
        Assert.assertTrue(errorMessage.toLowerCase().contains("incorrect"),
                "Expected invalid login validation message. Actual message: " + errorMessage);
        Assert.assertTrue(errorMessage.toLowerCase().contains("password") || errorMessage.toLowerCase().contains("email"),
                "The validation message should mention the invalid credentials. Actual message: " + errorMessage);
    }

    @Test(groups = {"Negative", "ErrorHandling"})
    public void invalidProductShouldNotBeVisibleInCart() {
        ProductCatalog productCatalog = landingpage.loginAct("jaunelia@gmail.com", "Ishaq@123");
        List<WebElement> products = productCatalog.getProductList();
        Assert.assertFalse(products.isEmpty(), "Product list should not be empty for a valid user.");

        productCatalog.addProductToCart("ZARA COAT 3");
        CartPage cartPage = productCatalog.goToCartPage();

        boolean productFound = cartPage.VerifyProductDisplay("ZARA COAT 999");
        Assert.assertFalse(productFound, "A non-existent product should not appear in the cart.");
    }

    @Test(groups = {"Negative", "ErrorHandling"})
    public void wrongCredentialsShouldNotAllowOrderPlacement() {
        landingpage.loginAct("ishaqahmed1548@gmail.com", "Ahmed@1223");

        String errorMessage = landingpage.getErrorMessage();
        Assert.assertTrue(errorMessage.toLowerCase().contains("incorrect"),
                "Wrong credentials should trigger the invalid login message. Actual message: " + errorMessage);
        Assert.assertFalse(errorMessage.toLowerCase().contains("thankyou for the order"),
                "A failed login should never show a successful order message.");
    }
}
