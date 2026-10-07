package rsWork.mavenRsFramewrk.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import rsWork.mavenRsFramewrk.CartPage;
import rsWork.mavenRsFramewrk.ProductCatalog;
import rsWork.mavenRsFramewrk.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void submitOrder() {
		String productName="ZARA COAT 3";
		landingpage.loginAct("ishaqahmed1548@gmail.com", "Ahme22d@1223");
		Assert.assertEquals("Incorrect email  pass2word.", landingpage.getErrorMessage());
	}
	
	@Test(groups= {"ErrorHandling"})
	public void productErrorValidations() throws IOException
	{
			String productName="ZARA COAT 3";
			ProductCatalog productCatalog=landingpage.loginAct("jaunelia@gmail.com", "Ishaq@123");
			List<WebElement> products=productCatalog.getProductList();
			productCatalog.addProductToCart(productName);
			CartPage cartPage=productCatalog.goToCartPage();
			
			Boolean match=cartPage.VerifyProductDisplay("ZARA COAT 33");
			Assert.assertFalse(match);
}

}