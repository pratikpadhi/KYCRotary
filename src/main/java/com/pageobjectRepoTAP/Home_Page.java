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

	@FindBy(xpath="//a[normalize-space(text())='Sign In']")
	private WebElement Sigin;
	@FindBy(xpath="//button[text()=' Allow cookies ']")
	private WebElement cookies;

	webdrivercommlib wb=new webdrivercommlib();
	
	public void gotologinpage() {
		cookies.click();
		Sigin.click();
	}
	
	}

	

