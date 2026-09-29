package rsWork.mavenRsFramewrk.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import rsWork.mavenRsFramewrk.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException
	{	
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//ChromeOptions options=new ChromeOptions();
			//options.addArguments("--headless=new");
			driver=new ChromeDriver();	
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
    }
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		  landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
		{
			HashMap<String, String> map=new HashMap<String, String>();
			map.put("email", "jaunelia@gmail.com");
			map.put("password", "Ishaq@123");
			map.put("product", "ZARA COAT 3");
			
			HashMap<String, String> map2=new HashMap<String, String>();
			map2.put("email", "ishaqahmed1548@gmail.com");
			map2.put("password", "Ahmed@123");
			map2.put("product", "ADIDAS ORIGINAL");
			return new Object[][] {{map},{map2}};
		}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source,file);
	return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	
	
}