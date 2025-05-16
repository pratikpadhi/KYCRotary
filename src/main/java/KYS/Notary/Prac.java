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
import com.pageobjectRepoTAP.Home_Page;
import com.pageobjectRepoTAP.LoginCase;
import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;

import groovy.time.Duration;

public class Prac{
	public static WebDriver driver;
	ExtentReports extent;
    ExtentTest test;
    LoginCase loginpg;
    static String value =null;
	
	
	@BeforeSuite
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://admin.mdiservicemogul.com/office-manager/login");

        // Properly instantiate page object with driver
        loginpg = new LoginCase(driver);
	}
	@BeforeMethod
	public void initElements() {
	    PageFactory.initElements(driver, this);
	}
	
	@BeforeClass 
	public void bfrcls() {
		loginpg = PageFactory.initElements(driver,LoginCase.class);
	}
	@AfterMethod
	public void clearData() {
		System.out.println("Clearing input data");
		try {
	        if (loginpg != null) {
	            loginpg.clearFields();
	        }
	    } catch (Exception e) {
	        System.out.println("Unable to clear fields after test. " + e.getMessage());
	    }
	}
	
	@Test(priority = 1)
	public void LoginwithNoData1() {
		System.out.println("No data Execute");
		
		loginpg.loginwithNodata();
	}
	
	
	@Test(priority = 2)
	public void LoginwithOnlyMail() {
		System.out.println("Only mail data Execute");

		loginpg.LoginwithonlyEmail();
	}
	
	
	@Test(priority = 3)
	public void LoginwithWrongData(){
		System.out.println("Wrong data Execute");
		loginpg.WrongData();
	}
	
	@Test(priority = 4)
	public void Login() {
		System.out.println("Correct Execute");
		loginpg.CorrectLogin();
		
		//clickInfo.click();
		//getMyPro.click();
	}
	
	@Test(priority = 5)
	public void UpdateProfile() {
		System.out.println("Executing logout");
		//clickInfo.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
	   // wait.until(ExpectedConditions.elementToBeClickable(logout));
	}
	
	
	/*public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}*/
		
}