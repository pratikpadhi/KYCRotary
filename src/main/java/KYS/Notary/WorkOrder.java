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


public class WorkOrder {
	WebDriver driver;
	ExtentReports extent;
    ExtentTest test;
    static String value =null;
    
	@FindBy(xpath="//p[contains(text(),'Work Orders')]")
	public WebElement Wkorder;
	
	@FindBy(xpath="//p[contains(text(),'Work Orders')]/ancestor::a/following-sibling::ul")
	public WebElement manageorder;
	
	@BeforeClass
	public void setUp() {
        driver = Prac.driver;  // Reuse the driver from Prac
        PageFactory.initElements(driver, this);
    }
	
	
	@Test(priority = 6)
	public void PlaceOrder(){
		
		System.out.println("2nd page");
		Wkorder.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		manageorder.click();
	}
}
	
