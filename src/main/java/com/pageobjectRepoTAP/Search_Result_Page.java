package com.pageobjectRepoTAP;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.genericLib.Browser;
import com.genericLib.constnts;
import com.sun.glass.events.KeyEvent;

public class Search_Result_Page {

	@FindBy(xpath="//a[text()='Televisions']")
	private List<WebElement> television;

	
	
	public boolean validate_searchlist_television() throws AWTException{
		
		if(television.size()>0)
			return true;
		else
			return false;
	}
	
	}

	

