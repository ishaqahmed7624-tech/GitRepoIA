package iaseleniumskills.iaselenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SelTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver.get("https://www.irctc.co.in/");
		Thread.sleep(4000);
		//a	[@class="XnhcQm"] and [@aria-label="About Us"]
		//driver.switchTo().alert().accept();
		Actions action=new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//button [@type='submit' and text()='English']"));
		action.moveToElement(element).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p-autocomplete [@id='origin']")).sendKeys("bengaluru");

	}

}
