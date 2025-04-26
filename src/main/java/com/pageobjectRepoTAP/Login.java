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

	@FindBy(xpath="//input[@name='email']")
	private WebElement username;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@FindBy(xpath="//span[text()='Please allow cookies']/parent::button")
	private WebElement Submit;
	@FindBy(xpath="//input[@formcontrolname='otp']")
	private WebElement otp;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement verify;
	webdrivercommlib wb=new webdrivercommlib();
	
	public void login(){
		Browser.driver.get(constnts.url_b);
		username.sendKeys(constnts.username);
		password.sendKeys(constnts.password);
		Submit.click();
	}
	
	public void validateotp(){
		otp.sendKeys(wb.getotp());
		verify.click();
		
	}
	
	}

	

