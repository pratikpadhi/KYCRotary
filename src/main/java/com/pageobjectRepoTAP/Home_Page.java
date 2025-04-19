package com.pageobjectRepoTAP;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.genericLib.Browser;
import com.genericLib.constnts;
import com.genericLib.webdrivercommlib;
import com.sun.glass.events.KeyEvent;

public class Home_Page {

	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	private WebElement search;

	webdrivercommlib wb=new webdrivercommlib();
	
	public void search_TV(String s) throws AWTException{
		
		search.sendKeys(s);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		wb.normalwait();
	}
	
	}

	

