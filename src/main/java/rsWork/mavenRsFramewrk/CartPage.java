package rsWork.mavenRsFramewrk;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuables.Utilities;

public class CartPage extends Utilities {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	public Boolean VerifyProductDisplay(String productName){
	Boolean match=cartProducts.stream().anyMatch(a -> a.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	public CheckOutPage goToCheckout(){
		checkoutEle.click();
		return new CheckOutPage(driver);
	}
}
