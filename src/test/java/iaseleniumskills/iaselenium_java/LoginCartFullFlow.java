package iaseleniumskills.iaselenium_java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginCartFullFlow {

	public static void main(String[] args) {
		String productName="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("jaunelia@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ishaq@123");
		driver.findElement(By.id("login")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
		List<WebElement> products=driver.findElements(By.cssSelector(".card-body"));
		WebElement prod= products.stream()
		.filter(product->product.findElement(By.cssSelector(".card-body b"))
		.getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
	}

}
