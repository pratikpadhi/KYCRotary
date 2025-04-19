package KYS.Notary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;

import com.genericLib.Browser;
import com.genericLib.ExcelLib;
import com.genericLib.Screenshot;
import com.genericLib.log1;
import com.genericLib.webdrivercommlib;
import com.pageobjectRepoTAP.Home_Page;
import com.pageobjectRepoTAP.Login;
import com.pageobjectRepoTAP.Search_Result_Page;
@Listeners(Screenshot.class)
public class TestScript {
	ExcelLib elib=new ExcelLib();
	webdrivercommlib wblib=new webdrivercommlib();
	WebDriver driver;
	Login loginpage;
	Home_Page homepage;
	Search_Result_Page search;
	static String value =null;
	
@BeforeTest
public void extendreport()
{
//	Browser.report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	//File dst=new File("C:\\Screen\\"+filename+"____"+timeStamp+".png");
	String dst1="report"+timeStamp;
	Browser.report = new ExtentReports(System.getProperty("user.dir")+"\\ExtendReports\\"+dst1+"\\ExtentReportResults.html");
	

}
	
@BeforeClass
	public void bfrcls(){
		driver=Browser.getbrowser();
		driver.manage().window().maximize();
	loginpage=	PageFactory.initElements(driver,Login.class);
	homepage=	PageFactory.initElements(driver,Home_Page.class);
	search=	PageFactory.initElements(driver,Search_Result_Page.class);
	
	log1.configure();
	 log1.info("Test Case execution for flipkart started.");
	// Browser.test = Browser.report.startTest("ExtentDemo");

}

	@Test
	public void TC01()
	{
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[1];
	   value = e.getMethodName();
	   Browser.test = Browser.report.startTest(value);
		//loginpage.login();
		 log1.info(value+" test case passed successfully");
		 Browser.test.log(LogStatus.PASS, "Navigated to the specified URL");

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
