package mainjava;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Factory;


public class LoginPage extends BaseClass{

	//Login
	
	@FindBy(xpath = "//*[@class='menu-sec header']//a[text()='Login']")
	WebElement Login;
	@FindBy(xpath = "//*[@name='email_id']")
	WebElement username;
	@FindBy(xpath = "//*[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement button;
	@FindBy(xpath = "//*[@name='code']//span//input")
	WebElement code;
	//Find Rotations
	@FindBy(xpath = "//button[text()='Search']")
	WebElement Search;
	@FindBy(xpath = "//*[@id='62d14360375e8c5f5b678866']//a")
	WebElement rotation;
	
	//upload resume
	@FindBy(xpath = "//*[@class='my-profiles-sec']//i")
	WebElement myprofile;
	@FindBy(xpath = "//*[@id='file-upload']")
	WebElement fileupload;
	@FindBy(xpath = "//*[text()='Update']")
	WebElement update;
	
	//find For booking assistance 
	@FindBy(xpath = "//*[@id='mat-input-0']")
	WebElement Hours;
	@FindBy(xpath = "//*[@id='mat-input-1']")
	WebElement date;
	@FindBy(xpath = "//*[@aria-label='Choose month and year']//span[@class='mat-button-wrapper']")
	WebElement paperworkdue;
	
	@FindBy(xpath = "//*[@id='mat-input-2']")
	WebElement startrotation;
	
	@FindBy(xpath = "//*[@id='mat-input-3']")
	WebElement reotationend;
	
	@FindBy(xpath = "//*[@id='scrollup']//select[@formcontrolname='clinical_experience']")
	WebElement clinical_experience;
	
	@FindBy(xpath = "//*[@id='card-name']")
	WebElement cardHolder;
	
	@FindBy(xpath = "//input[@name='cardnumber' and @inputmode='numeric']")
	WebElement CardNumber;
	
	@FindBy(xpath = "//input[@name='exp-date']")
	WebElement EXPDATE;
	@FindBy(xpath = "//input[@name='cvc']")
	WebElement cvc;
	
	@FindBy(xpath = "//input[@id='card-zip']")
	WebElement zipcode;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement billing_address;
	
	@FindBy(xpath = "//*[text()='Make default for all payments']")
	WebElement makedefaultcardpayment;
	
	@FindBy(xpath = "//*[@for='school']")
	WebElement preceptor_and_clinical_site;
	
	@FindBy(xpath = "//*[@for='responsibility']")
	WebElement responsibility;
	
	@FindBy(xpath = "//*[@for='Acknowledgements']")
	WebElement Acknowledgements;
	
	@FindBy(xpath = "//*[@id='scrollup']//div[3]//button")
	WebElement paynow;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}


	public void doLogin() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\Desktop\\NPHUB Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet  = workbook.getSheetAt(0);
		Login.click();
		String User=sheet.getRow(2).getCell(0).getStringCellValue();
		username.sendKeys(User);
		String pass=sheet.getRow(2).getCell(1).getStringCellValue();
		password.sendKeys(pass);
		button.click();
		Thread.sleep(1000);
		Reporter.log("Student Logged in Successfully", true);
			
		}
	
	public void dashBoradRoationFind() throws IOException, InterruptedException
	{
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\Desktop\\NPHUB Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet1  = workbook.getSheetAt(1);
		String rotationcode=sheet1.getRow(1).getCell(0).getStringCellValue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().refresh();
		System.out.println(driver.getWindowHandle());
		code.sendKeys(rotationcode);
		Search.click();
		Thread.sleep(3000);
		rotation.click();	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)");
		Reporter.log("Student Found Rotation", true);
	}
	
	public void uploadUserResume() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='la la-bars cn2']")).click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tree_widget-sec']//a[text()='My Profile']")));
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Edit Profile']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
		fileupload.sendKeys("C:\\Users\\Admin\\Desktop\\Resume.pdf");
		update.click();
		Reporter.log("Resume Uploaded Successfully", true);
		Thread.sleep(9000);
		
		
	}
	
	public void forBookingAssistance() throws IOException, InterruptedException
	{
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\Desktop\\NPHUB Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet  = workbook.getSheetAt(2);
		String NoOfHours=sheet.getRow(3).getCell(0).getStringCellValue();
		Reporter.log("No of Hours Noted", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String primary=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		
		Set<String>allWinId=driver.getWindowHandles();
		for(String eachID : allWinId)
		if(!eachID.equals(primary))
		driver.switchTo().window(eachID);
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		Hours.sendKeys(NoOfHours);
		date.click();
		paperworkdue.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String Year=sheet.getRow(3).getCell(3).getStringCellValue();
		System.out.println(Year);
		
		driver.findElement(By.xpath("//*[@aria-label='"+Year+"']")).click();
		
		String Month=sheet.getRow(3).getCell(2).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@class='mat-calendar-body-cell-content' and text()='"+Month+"']")).click();
		
		String Date=sheet.getRow(3).getCell(1).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@class='mat-calendar-body-cell-content' and text()='"+Date+"']")).click();
	
		Reporter.log("Paper Work Due date noted", true);
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-input-2']")));
		element.click();
		paperworkdue.click();
		String ri=sheet.getRow(3).getCell(6).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@aria-label='"+ri+"']")).click();
		String rotationMonth=sheet.getRow(3).getCell(5).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@class='mat-calendar-body-cell-content' and text()='"+rotationMonth+"']")).click();
		
		String StartDate=sheet.getRow(3).getCell(4).getStringCellValue();
		driver.findElement(By.xpath("//*[@class='mat-calendar-body-cell-content' and text()='"+StartDate+"']")).click();
		Reporter.log("Rotation start date noted", true);
		
		WebDriverWait wait1=new WebDriverWait(driver,40);
		WebElement element1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-input-3']")));
		element1.click();
		paperworkdue.click();
		String ei=sheet.getRow(3).getCell(9).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@aria-label='"+ei+"']")).click();
		String rotationEndMonth=sheet.getRow(3).getCell(8).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@class='mat-calendar-body-cell-content' and text()='"+rotationEndMonth+"']")).click();
		String endDate=sheet.getRow(3).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//*[@class='mat-calendar-body-cell-content' and text()='"+endDate+"']")).click();
		Reporter.log("Rotation End date noted", true);
		Thread.sleep(2000);
		String Experience=sheet.getRow(3).getCell(10).getStringCellValue();
		Select sel= new Select(clinical_experience);
		sel.selectByVisibleText(Experience);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,550)");
		WebDriverWait wait2=new WebDriverWait(driver,30);
		WebElement element2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Request Your Preceptor']")));
		element2.click();
		Thread.sleep(2000);
		Reporter.log("Please make payment to sent request to Preceptor", true);
	
	}
	
	public void makePayment() throws InterruptedException, IOException
	{
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\Desktop\\NPHUB Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet  = workbook.getSheetAt(3);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,450)");
		String cardholdername=sheet.getRow(3).getCell(0).getStringCellValue();
		cardHolder.sendKeys(cardholdername);
		Thread.sleep(2000);
		WebElement cardnumber=driver.findElement(By.xpath("//*[@id='card-card-number']"));
		cardnumber.click();
		WebElement iframe=driver.findElement(By.xpath("//*[@title='Secure card number input frame']"));
		driver.switchTo().frame(iframe);
		String atmcardnumber=sheet.getRow(3).getCell(1).getStringCellValue();
		CardNumber.sendKeys(atmcardnumber);	
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		
		WebElement expdate=driver.findElement(By.xpath("//*[@id='card-card-expiry']"));
		expdate.click();
		WebElement iframe1=driver.findElement(By.xpath("//*[@title='Secure expiration date input frame']"));
		driver.switchTo().frame(iframe1);
		String monthyear=sheet.getRow(3).getCell(2).getStringCellValue();
		EXPDATE.sendKeys(monthyear);		
		driver.switchTo().parentFrame();
		
		
		WebElement iframe2=driver.findElement(By.xpath("//*[@title='Secure CVC input frame']"));
		driver.switchTo().frame(iframe2);
		String cvv=sheet.getRow(3).getCell(3).getStringCellValue();
		cvc.sendKeys(cvv);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		String billingzipcode=sheet.getRow(3).getCell(4).getStringCellValue();
		zipcode.sendKeys(billingzipcode);
		Thread.sleep(1000);
		String address=sheet.getRow(3).getCell(5).getStringCellValue();
		billing_address.sendKeys(address);
		Thread.sleep(1000);
//		makedefaultcardpayment.click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//label[@for='makeDefaultCard']"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		WebElement element1 = driver.findElement(By.xpath("//label[@for='school']"));
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click();", element1);
		Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//label[@for='responsibility']"));
		JavascriptExecutor js3 = (JavascriptExecutor)driver;
		js3.executeScript("arguments[0].click();", element2);
		Thread.sleep(1000);
		
		WebElement element3 = driver.findElement(By.xpath("//label[@for='Acknowledgements']"));
		JavascriptExecutor js4 = (JavascriptExecutor)driver;
		js4.executeScript("arguments[0].click();", element3);
		Thread.sleep(1000);
		
		WebElement element4 = driver.findElement(By.xpath("//*[@id='scrollup']//div[3]//button"));
		JavascriptExecutor js5 = (JavascriptExecutor)driver;
		js5.executeScript("arguments[0].click();", element4);
		Thread.sleep(1000);
		Reporter.log("Payment Done", true);
		Reporter.log("Request sent to Preceptor successfully", true);
		
		String Request_ID = driver.findElement(By.xpath("//*[@id='scrollup']//app-congratulations//div[2]//p[1]")).getText();
		System.out.println("Your Request ID is: ");
		Reporter.log(Request_ID,true);
		Thread.sleep(2000);
	}
	
	public void verifypreceptorLogin() throws IOException
	{
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\Desktop\\NPHUB Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet  = workbook.getSheetAt(4);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev.nphub.com/preceptor/login");
		driver.findElement(By.xpath("//*[text()='Login Here']")).click();
		String userename=sheet.getRow(3).getCell(1).getStringCellValue();
		String password=sheet.getRow(3).getCell(2).getStringCellValue();
				
		driver.findElement(By.xpath("//*[@name='email_id']")).sendKeys(userename);
		
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		
		Reporter.log("Preceptor Login Succesfully", true);
				
	}
	
	public void acceptRequestforStudent() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='collapsablePanelreject0']//parent::div//button[text()='Accept']"))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Reporter.log("Student requested Accepted By Preceptor", true);
		}
	
	public void preceptorPaperwork() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(30000);
		System.out.println(driver.getWindowHandle());
		Set<String>allWinId=driver.getWindowHandles();
		System.out.println("All"+allWinId);
		
		for(String eachID : allWinId)
		{
			driver.switchTo().window(eachID);
			System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Preceptor Paperwork"))
		{
			System.out.println(driver.getTitle());
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebDriverWait wait1 = new WebDriverWait(driver, 10);Thread.sleep(3000);
			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Start']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
			Thread.sleep(3000);
			WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Signature']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);
			Thread.sleep(3000);
			WebElement element3 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Accept and sign']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element3);
			Thread.sleep(3000);
			WebElement element4 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Finish']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element4);
			
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Download']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			Thread.sleep(5000);
								
		}
		Thread.sleep(5000);
		
		
		
	  }
		Reporter.log("First Form Accepted and Signed", true);
	}
	
	public void schoolAffiliationAgreement() throws IOException, InterruptedException
	{
		Set<String>allWinId1=driver.getWindowHandles();
		System.out.println(driver.getTitle());
		for(String eachID1 : allWinId1)
		{System.out.println(driver.getTitle());
			driver.switchTo().window(eachID1);
		if(driver.getTitle().contains("School Affiliation Agreement"))
			{
			System.out.println(driver.getTitle());
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			Thread.sleep(3000);
			WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Start']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
			Thread.sleep(3000);
			WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Signature']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);
			Thread.sleep(3000);
			WebElement element3 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Accept and sign']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element3);
			Thread.sleep(3000);
			WebElement element4 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Finish']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element4);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Download']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			Thread.sleep(5000);
			}
		}
		Reporter.log("Second Form Accepted and Signed", true);
	}
	public void payAndAcceptRotation() throws IOException, InterruptedException
	{
		Reporter.log("Student need to pay remining fee in One time OR Installation", true);
		driver.get("https://dev.nphub.com/student/login");
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\Desktop\\NPHUB Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet  = workbook.getSheetAt(0);
		String User=sheet.getRow(2).getCell(0).getStringCellValue();
		username.sendKeys(User);
		String pass=sheet.getRow(2).getCell(1).getStringCellValue();
		password.sendKeys(pass);
		button.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Pay & Download')]"))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
		
	
	}
	
	public void payRemainingFee() throws IOException, InterruptedException, AWTException
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Reporter.log("Please accept Terms And Conditions", true);
		WebElement element5 = driver.findElement(By.xpath("//*[@id='termandCondition']"));
		JavascriptExecutor js6 = (JavascriptExecutor)driver;
		js6.executeScript("arguments[0].click();", element5);
		Reporter.log("Terms And Conditions Accepted", true);
		WebElement element4 = driver.findElement(By.xpath("//*[@id='scrollup']//div[3]//button"));
		JavascriptExecutor js5 = (JavascriptExecutor)driver;
		js5.executeScript("arguments[0].click();", element4);
		Reporter.log("Thank You, You have paid Remaining Fee ", true);
		Thread.sleep(60000);
		WebElement element7 = driver.findElement(By.xpath("//*[contains(text(),'My school has approved')]"));
		JavascriptExecutor js7 = (JavascriptExecutor)driver;
		js7.executeScript("arguments[0].click();", element7);
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyPress(KeyEvent.VK_ENTER);	
		 Reporter.log("All Documents have been Downloded", true);
		
	}
 }


