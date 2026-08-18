package iaseleniumskills.iaselenium_java;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Spicejet {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.spicejet.com/");
	Thread.sleep(3000);
	//System.out.println(driver.findElement(By.xpath("//div[text()= 'one way']")).i;
	driver.findElement(By.xpath("//div[text()= 'one way']")).click();
	//System.out.println(driver.findElement(By.xpath("//div[text()= 'one way']")).isSelected());
	System.out.print("it is selected");
	driver.findElement(By.xpath("(//input [@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//input [@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).sendKeys("be");
	//driver.findElement(By.xpath("(//div[text()='Kempegowda International Airport']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input [@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).sendKeys("gox");
	//driver.findElement(By.xpath("(//div[text()='North Goa']")).click();
	driver.findElement(By.className("css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-17b3b9k r-1otgn73 r-1aockid")).click();
	driver.findElement(By.xpath("//div[text()='Passengers']")).click();
	for(int i=1;i<4;i++) {
		driver.findElement(By.xpath("//div [@data-testid='Adult-testID-plus-one-cta']")).click();
	}
	Assert.assertEquals(driver.findElement(By.xpath("(//div [@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")).getText(), "4 Adults");
	driver.findElement(By.xpath("(//div[text()='Govt. Employee'])[2]")).click();
	driver.findElement(By.xpath("//div[text()='Search Flight']")).click();
	
}
}
