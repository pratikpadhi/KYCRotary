package com.pageobjectRepoTAP;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.genericLib.Browser;
import com.genericLib.constnts;
import com.genericLib.webdrivercommlib;
import com.relevantcodes.extentreports.LogStatus;

public class LoginCase {
	public static WebDriver driver;
	
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
	
	/*public void initBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        // Initialize the Chrome WebDriver
        driver = new ChromeDriver();
      //  driver.manage().window().maximize();
        driver.get("https://admin.mdiservicemogul.com/office-manager/login");
        PageFactory.initElements(driver, this);
	}*/
	
	public LoginCase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clearFields() {
		username.clear();
        password.clear();
    }
	
	public void loginwithNodata() {
		/*StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	   String value = e.getMethodName();
		 Browser.test = Browser.report.startTest(value);*/
		username.sendKeys(" ");
		password.sendKeys(" ");
		signin.click();	
		//Browser.test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	
	public void LoginwithonlyEmail() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
	    wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys("ramom@yopmail.com");
		password.sendKeys(" ");
		signin.click();	
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	
	public void WrongData() {
		/*StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	   String value = e.getMethodName();
		 Browser.test = Browser.report.startTest(value);*/
		
		username.sendKeys("ramom54@yopmail.com");
		password.sendKeys("Test@123888");
		signin.click();	
		/*Assert.assertEquals(invalidlogin.getText(), "You have entered invalid credentials");
		 Browser.test.log(LogStatus.PASS,Browser.test.addScreenCapture(capture(driver))+ "No Login with invalid credentials");*/
	}
	
	public void CorrectLogin() {
		
		username.sendKeys("ramom@yopmail.com");
		password.sendKeys("Test@123");
		signin.click();	
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
	    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-message")));
	}
 
	

}
