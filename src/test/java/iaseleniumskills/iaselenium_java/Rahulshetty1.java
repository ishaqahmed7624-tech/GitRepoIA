package iaseleniumskills.iaselenium_java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Rahulshetty1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	//	Assert.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement elem=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown=new Select(elem);
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		System.out.println("list of elements");
		List <WebElement> elems =dropdown.getOptions();
		//List<WebElement> elems=driver.findElements(By.xpath("//select [@id='ctl00_mainContent_DropDownListCurrency']"));
	for(WebElement s:elems)
	{
		System.out.println(s.getText());
	}
driver.quit();
	}

}

//button [contains(@class,'inline-flex items-center justify-center gap-2 ')]