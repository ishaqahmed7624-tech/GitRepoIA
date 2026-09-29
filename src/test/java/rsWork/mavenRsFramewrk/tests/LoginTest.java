package rsWork.mavenRsFramewrk.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rsWork.mavenRsFramewrk.CartPage;
import rsWork.mavenRsFramewrk.CheckOutPage;
import rsWork.mavenRsFramewrk.ConfirmationPage;
import rsWork.mavenRsFramewrk.LandingPage;
import rsWork.mavenRsFramewrk.OrderPage;
import rsWork.mavenRsFramewrk.ProductCatalog;
import rsWork.mavenRsFramewrk.TestComponents.BaseTest;


public class LoginTest extends BaseTest{
	String productName="ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Purchase"})
public void submitOrder(HashMap<String, String> input) throws IOException
{
		
		//LandingPage landingpage=launchApplication();
		ProductCatalog productCatalog=landingpage.loginAct(input.get("email"), input.get("password"));
		
		List<WebElement> products=productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("product"));
		CartPage cartPage=productCatalog.goToCartPage();
		
		Boolean match=cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
	 	ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String confirmationMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		}

@Test (dependsOnMethods= {"submitOrder"})
public void OrderHistoryTest()
{
	//"ZARA COAT 3"
	ProductCatalog productCatalog=landingpage.loginAct("jaunelia@gmail.com", "Ishaq@123");
	OrderPage ordersPage=productCatalog.goToOrdersPage();
	Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	
}




/*@DataProvider
public Object[][] getData()
{
	return new Object[][] {{"jaunelia@gmail.com","Ishaq@123", "ZARA COAT 3"},{"ishaqahmed1548@gmail.com","Ahmed@123","ADIDAS ORIGINAL"}};
}*/

}
 
