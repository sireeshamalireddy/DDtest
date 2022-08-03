package com.vcentry.lab.page;

import com.vcentry.lab.initializer.Locator;

public class HomePage {
 public static void clickFrameworkForm(){
	 Locator.getElementById("HOMEPAGE_CLICK_FRAMEWORKFORMS_ID").click();
	 
 }
 public static void clicksimplekForm(){
	 Locator.getElementById("HOMEPAGE_CLICK_SIMPLEFORM_ID").click();
	 
 }
 public static void clickLogout(){
	 Locator.getElementBylinkText("HOMEPAGE_CLICK_LOGOUT_LINKTEXT").click();;
 }
	
}
