package com.vcentry.lab.page;

import com.vcentry.lab.initializer.Initializer;
import com.vcentry.lab.initializer.Locator;

public class LoginPage extends Initializer {
	//username type,password type.login click,signup cliclk,
	public static void enterUserName(String data){
		Locator.getElementByName("LOGINPAGE_TYPE_USERNAME_NAME").sendKeys("sireesha");
		
	}
	public static void enterPassword(String data){
		Locator.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").sendKeys("Sogeti1234");
		
	}
	public static void clickLogin(){
		Locator.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").submit();
		
	}
	public static void clickSignUp(){
		Locator.getElementBylinkText("LOGINPAGE_CLICK_SIGNUP_LINKTEXT").click();
		
	}
}
