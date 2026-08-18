package iaseleniumskills.iaselenium_java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdwn {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	//driver.findElement(By.xpath("//div [@id='divpaxinfo']")).click();
	driver.findElement(By.xpath("//input [@id='autosuggest']")).sendKeys("Ind");
	Thread.sleep(2000);
	List <WebElement> options=driver.findElements(By.xpath("//li [@class='ui-menu-item']"));
	for(WebElement option:options) {
		if(option.getText().equalsIgnoreCase("India"));{
			option.click();
		}
	}
	
	
	}

} 
