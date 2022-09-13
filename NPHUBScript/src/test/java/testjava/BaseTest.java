package testjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.BaseClass;
import mainjava.LoginPage;

public class BaseTest extends BaseClass{

	@BeforeSuite
	public void initializingWeb() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		
		driver.get("https://dev.nphub.com");
		
		
		driver.manage().window().maximize();
		
		
	}
	
	
	@BeforeMethod
	public void allPageObject() throws IOException
	{
		 sign=new LoginPage(driver);
		   
	}
	
	@AfterSuite
	public void tearDowmBrowser() throws InterruptedException
	{ 
		Thread.sleep(1000);
		driver.quit();
	}
}
