package iaseleniumskills.iaselenium_java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selfintro {
	
	public static void main(String[] args)
	{	
		
 		WebDriver driver1=new ChromeDriver();
 		driver1.get("https://www.flipkart.com/");
 		Object a = driver1.getTitle();
 		System.out.println(a);
 		System.out.println("Chrome out put " + driver1.getCurrentUrl());
 		//driver1.close();
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://en.wikipedia.org/wiki/Jaun_Elia");
 		Object b = driver.getTitle();
 		System.out.println(b);
 		System.out.println("edge output "+driver.getCurrentUrl());
 		//driver.close();
		
	}

}
 