package com.genericLib;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class webdrivercommlib {
public void waitforpagetoload(){
	Browser.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
public void waitforelemetpresent(WebElement wb){
	WebDriverWait wait=new WebDriverWait(Browser.driver,20);
	wait.until(ExpectedConditions.visibilityOf(wb));
}
public boolean verifytext(String expectedResult,WebElement wb){
	boolean flag=false;
	String ActualResult=wb.getText();
	if(expectedResult.equals(ActualResult)){
		flag=true;
		System.out.println("Msg is verified==pass");
	}else{
		System.out.println("Msg is not verified==fail");
	}
	return flag;
	
}

public void acceptalert(){
	Alert alt=Browser.driver.switchTo().alert();
alt.accept();
}
public void cancelalert(){
	Alert alt=Browser.driver.switchTo().alert();
alt.dismiss();
}
public String alertText(){
	Alert alt=Browser.driver.switchTo().alert();
String text=alt.getText();
return text;
}
public void normalwait(){
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public static void movetoelement(int a,String locator)
{
	Actions act= new Actions(Browser.driver);
	act.moveToElement(Locator_wait.GetElement(a, locator)).perform();
}

public static void contextclick(int a,String locator)
{
	Actions act= new Actions(Browser.driver);
	act.contextClick(Locator_wait.GetElement(a, locator)).perform();
}

public static void contextclickandsendchar(int a,String locator,String d)
{
	Actions act= new Actions(Browser.driver);
	act.contextClick(Locator_wait.GetElement(a, locator)).perform();
	act.sendKeys(d);
}

public static void clickandhold(int a,String locator)
{
	Actions act= new Actions(Browser.driver);
	act.clickAndHold(Locator_wait.GetElement(a, locator)).perform();
}

public static void doubleclick(int a,String locator)
{
	Actions act= new Actions(Browser.driver);
	act.doubleClick(Locator_wait.GetElement(a, locator)).perform();
}
public static void draganddrop(int a,String locator,int b,String locator1)
{
	Actions act= new Actions(Browser.driver);
	act.dragAndDrop(Locator_wait.GetElement(a, locator),Locator_wait.GetElement(b, locator1)).perform();
}

public static void selectbyindex(int a,String locator,int b)
{

	Select sel=new Select(Locator_wait.GetElement(a, locator));
	sel.selectByIndex(b);
}

public static void selectbyvalue(int a,String locator,String value)
{

	Select sel=new Select(Locator_wait.GetElement(a, locator));
	sel.selectByValue(value);
}

public static void selectbyvisible(int a,String locator,String value)
{

	Select sel=new Select(Locator_wait.GetElement(a, locator));
	sel.selectByVisibleText(value);
}

public static List<WebElement> getoptions(int a,String locator)
{
	Select sel=new Select(Locator_wait.GetElement(a, locator));
	return(sel.getOptions());
}

public static boolean isMultiple(int a,String locator)
{
	Select sel=new Select(Locator_wait.GetElement(a, locator));
	return(sel.isMultiple());
}

public static void deselectall(int a,String locator)
{

	Select sel=new Select(Locator_wait.GetElement(a, locator));
	sel.deselectAll();
}

public static void deselectbyindex(int a,String locator,int b)
{

	Select sel=new Select(Locator_wait.GetElement(a, locator));
	sel.deselectByIndex(b);
}
public static void deselectbyvalue(int a,String locator,String value)
{

	Select sel=new Select(Locator_wait.GetElement(a, locator));
	sel.deselectByValue(value);
}

public static void deselectbyvisible(int a,String locator,String value)
{

	Select sel=new Select(Locator_wait.GetElement(a, locator));
	sel.deselectByVisibleText(value);
}

public static List<WebElement> getselectedoptions(int a,String locator)
{
	Select sel=new Select(Locator_wait.GetElement(a, locator));
	return(sel.getAllSelectedOptions());
}

public static WebElement getfirstselectedoptions(int a,String locator)
{
	Select sel=new Select(Locator_wait.GetElement(a, locator));
	return(sel.getFirstSelectedOption());
}

public static String getotp()
{
	RequestSpecification req=	new RequestSpecBuilder().setBaseUri("https://api.kys-tech.com")
			.setContentType(ContentType.JSON).build();
RequestSpecification reqLogin =given().relaxedHTTPSValidation().log().all().spec(req).body("{\r\n" + 
				"    \"email\": \"arnab@technoexponent.com\"\r\n" + 
				"}");
		String response = reqLogin.when().post("/api/fetch-user-otp").asString();
		JsonPath js = new JsonPath(response);
		String otp = js.getString("otp");
		System.out.println(otp);
		return otp;
}

}
