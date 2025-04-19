package com.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Browser {
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
public static WebDriver getbrowser(){
	if(constnts.Browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		 driver=new ChromeDriver();
	}else if(constnts.Browser.equals("ie")){
		System.setProperty("webdriver.ie.driver","");
		 driver=new InternetExplorerDriver();
	}else if(constnts.Browser.equals("firefox")){
		 driver=new FirefoxDriver();
	}
	return driver;
}
}
