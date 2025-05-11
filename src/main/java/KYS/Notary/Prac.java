package KYS.Notary;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.genericLib.Browser;
import com.genericLib.log1;
import com.genericLib.webdrivercommlib;
import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;

import groovy.time.Duration;

public class Prac{
	public static WebDriver driver;
	ExtentReports extent;
    ExtentTest test;
    static String value =null;
    
	@FindBy(xpath="//input[@name ='email']")
	public WebElement username;
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	@FindBy(xpath="//button[text()='Sign in']")
	public WebElement signin; 
	@FindBy(xpath="//div[@class='info']/img")
	public WebElement clickInfo;
	@FindBy(xpath="//a[text()='My Profile']")
	public WebElement getMyPro;
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logout; 
	@FindBy(xpath="//div[@class='alert alert-danger alert-block']/strong")
	public WebElement invalidlogin; 
	
	webdrivercommlib wb=new webdrivercommlib();
	
	
	@BeforeSuite
	public void openBrowser() {
		
        
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");

	        // Initialize the Chrome WebDriver
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://admin.mdiservicemogul.com/office-manager/login");
	        PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void initElements() {
	    PageFactory.initElements(driver, this);
	}
	
	 @AfterMethod
	    public void clearFields() {
	        try {
	            username.clear();
	            password.clear();
	        } catch (Exception e) {
	            System.out.println("Could not clear fields: " + e.getMessage());
	        }
	    }
	 
	@BeforeTest
	public void extendreport()
	{
//		Browser.report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		//File dst=new File("C:\\Screen\\"+filename+"____"+timeStamp+".png");
		String dst1="report"+timeStamp;
		Browser.report = new ExtentReports(System.getProperty("user.dir")+"\\ExtendReports\\"+dst1+"\\ExtentReportResultsprac.html");
		
		log1.configure();
		 log1.info("Test Case execution for MDI started.");
	}
	
	
	
	@Test(priority = 1)
	public void LoginwithNoData() {
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	   value = e.getMethodName();
		 Browser.test = Browser.report.startTest(value);
		username.sendKeys(" ");
		password.sendKeys(" ");
		signin.click();	
		Browser.test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	@Test(priority = 2)
	public void LoginwithOnlyMail() {
		
		username.sendKeys("ramom@yopmail.com");
		password.sendKeys(" ");
		signin.click();	
	}
	@Test(priority = 3)
	public void LoginwithWrongData() throws IOException {
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	   value = e.getMethodName();
		 Browser.test = Browser.report.startTest(value);
		
		username.sendKeys("ramom54@yopmail.com");
		password.sendKeys("Test@123888");
		signin.click();	
		Assert.assertEquals(invalidlogin.getText(), "You have entered invalid credentials");
		 Browser.test.log(LogStatus.PASS,Browser.test.addScreenCapture(capture(driver))+ "No Login with invalid credentials");
	}
	@Test(priority = 4)
	public void Login() {
		
		username.sendKeys("ramom@yopmail.com");
		password.sendKeys("Test@123");
		signin.click();	
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-message")));
	    
		clickInfo.click();
		getMyPro.click();
	}
	
	@Test(priority = 5)
	public void UpdateProfile() {
		System.out.println("Executing logout");
		clickInfo.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
	   // wait.until(ExpectedConditions.elementToBeClickable(logout));
	}
	
	@AfterMethod
    public void TearDown(ITestResult result) throws IOException
    {
         if(ITestResult.FAILURE == result.getStatus())
           {
           log1.warn(value+" test case failed.**");
           Browser.test.log(LogStatus.FAIL,Browser.test.addScreenCapture(capture(driver))+ "Test Failed");

           }
    }
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	
	@AfterClass
	public void last()
	{
		Browser.report.endTest(Browser.test);
		
		Browser.report.flush();

		log1.info("Test Case execution for customer_MD completed.");
		//driver.quit();
		
	}
		
}