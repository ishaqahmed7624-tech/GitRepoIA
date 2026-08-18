package iaseleniumskills.iaselenium_java;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitttFlow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(4));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text() ='Free Access to InterviewQues/ResumeAssistance/Material']")).click();
		Set
		<String> it= driver.getWindowHandles();
		Iterator<String> win=it.iterator();
		String parent=win.next();
		String child = win.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.xpath("//p [@class='im-para red']/strong/a")));
		//driver.findElement(By.cssSelector("p.im-para.red"))
		//String name= driver.findElement(By.xpath("//p [@class='im-para red']/strong/a")).getText();
		driver.switchTo().window(parent);
		String name= driver.findElement(By.xpath("(//p[@class='text-center text-white']/b/i)[1]")).getText();
		driver.findElement(By.xpath("//input [@id='username']")).sendKeys(name);
		String pass= driver.findElement(By.xpath("(//p[@class='text-center text-white']/b/i)[2]")).getText();
		driver.findElement(By.id("password")).sendKeys(pass);
		System.out.println(driver.findElement(By.xpath("//input [@value='user']")).isDisplayed());
		driver.findElement(By.xpath("//input [@value='user']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
	//	driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		WebElement ele=driver.findElement(By.cssSelector("select.form-control"));
		Select dd=new Select(ele);
		dd.selectByVisibleText("Teacher");
		driver.findElement(By.xpath("//input [@id='terms']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input [@id='terms']")).isSelected(), true);
		driver.findElement(By.cssSelector("input.btn.btn-info.btn-md")).click();
		
		
	}

}
