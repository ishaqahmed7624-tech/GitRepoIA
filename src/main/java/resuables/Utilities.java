package resuables;

import java.time.Duration;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rsWork.mavenRsFramewrk.CartPage;
import rsWork.mavenRsFramewrk.OrderPage;



public class Utilities{

	WebDriver driver;
	public Utilities(WebDriver driver) {
		//to catch that driver in child class we create constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {
	WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
	w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}
	
	public void waitForElementToAppear(WebElement findBy) {
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage; 
	}
	public OrderPage goToOrdersPage() {
		orderHeader.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
}

