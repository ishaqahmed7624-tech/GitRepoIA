package rsWork.mavenRsFramewrk;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuables.Utilities;

public class LandingPage extends Utilities {
	WebDriver driver;
	public LandingPage(WebDriver driver){
		super(driver); //this is a child and utilities is parnt to give life to driver we use super with driver as argument, it will call its immediate parent
		//we shoudl not create object each time so we can use above technique.
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement um;
	
	@FindBy(id="userPassword")
	WebElement up;
	
	@FindBy(id="login")
	WebElement btn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalog loginAct(String mail,String pass) {
		um.sendKeys(mail);
		up.sendKeys(pass);
		btn.click();
		ProductCatalog productCatalog=new ProductCatalog(driver);
		return productCatalog;
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errorMessage)	;
		return errorMessage.getText();
	}
	 
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
