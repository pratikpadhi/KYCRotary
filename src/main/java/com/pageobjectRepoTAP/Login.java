package com.pageobjectRepoTAP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import com.genericLib.Browser;
import com.genericLib.constnts;
import com.genericLib.webdrivercommlib;

public class Login {

	@FindBy(xpath="//input[@name='userName']")
	private WebElement usernameedt;
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordedt;
	@FindBy(name="login")
	private WebElement loginbtn;
	@FindBy(xpath="//div/button")
	private List<WebElement> cancel;
	webdrivercommlib wb=new webdrivercommlib();
	
	public void login(){
		Browser.driver.get(constnts.url_b);
		usernameedt.sendKeys(constnts.username_b);
		passwordedt.sendKeys(constnts.password_b);
		loginbtn.click();
	}
	
	public void guest_login(){
		Browser.driver.get(constnts.url_b);
		wb.normalwait();
		cancel.get(1).click();
		
	}
	
	}

	

