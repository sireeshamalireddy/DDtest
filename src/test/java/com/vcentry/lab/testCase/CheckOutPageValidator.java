package com.vcentry.lab.testCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.lab.initializer.Initializer;
import com.vcentry.lab.initializer.Locator;
import com.vcentry.lab.inputReader.InputReader;
import com.vcentry.lab.page.CheckoutPage;
import com.vcentry.lab.page.HomePage;
import com.vcentry.lab.page.LoginPage;
import com.vcentry.lab.screenshotgenetor.ScreenshotGenerator;

public class CheckOutPageValidator extends Initializer{
	@BeforeTest
	public void setUp() throws FileNotFoundException, IOException{
		//intialize();//opens the browser
		
	}
	
	@Test(dataProvider="CheckoutTest")
	//                                 0,                    1              2            3                 4                 5       6                 7                  8
	public void validateCheckoutPage(String testdata,String user,String password,String productname,String mobile,String email,String prodcat, String productQty, String pruchaser ) throws FileNotFoundException, IOException, InterruptedException{
		intialize();//opens the browser
		
		
		log=reports.startTest("start "+testdata, "validate - "+testdata);
		log.log(LogStatus.PASS, testdata+" -  initialized");
		wd.get(envprop.getProperty("URL"));
		log.log(LogStatus.PASS, "url loaded successfully");
		/*// step1
		wd.findElement(By.name("username")).sendKeys("sireesha");
		wd.findElement(By.name("password")).sendKeys("Sogeti1234");
		wd.findElement(By.name("password")).submit();
		*/
		//step2
		/*
		wd.findElement(By.name(Locatorprop.getProperty("LOGINPAGE_TYPE_USERNAME_NAME"))).sendKeys("sireesha");
		wd.findElement(By.name(Locatorprop.getProperty("LOGINPAGE_TYPE_PASSWORD_NAME"))).sendKeys("Sogeti1234");
		wd.findElement(By.name(Locatorprop.getProperty("LOGINPAGE_TYPE_PASSWORD_NAME"))).submit();
		*/
		// step 3
		
		/*
		Locator.getElementByName("LOGINPAGE_TYPE_USERNAME_NAME").sendKeys("sireesha");
		Locator.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").sendKeys("Sogeti1234");
		Locator.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").submit();
		*/
		//step page object readble,resuable
		LoginPage.enterUserName(user);//0
		LoginPage.enterPassword(password);//1
		LoginPage.clickLogin();
		log.log(LogStatus.PASS, "url completed successfully");
		wd.get(envprop.getProperty("LAB_URL"));
		
		HomePage.clickFrameworkForm();
		HomePage.clicksimplekForm();
		log.log(LogStatus.PASS, "home page completed successfully");
		CheckoutPage.enterProductName(productname);//2
		CheckoutPage.enterEmail(mobile);//3
		CheckoutPage.enterMobile(email);//4
		CheckoutPage.selectProdCat(prodcat);//5
		CheckoutPage.ClickProductQuant(productQty);//6
		CheckoutPage.enterPurchaserName(pruchaser);//7
		CheckoutPage.Clickgst();
		CheckoutPage.ClickPayment();
		
		CheckoutPage.clickplaceOrder();
		log.log(LogStatus.PASS, "checkout page completed successfully");
		
		
		
		
		
		
	}
	@DataProvider(name="CheckoutTest")
	public static Object[][] getData() throws IOException{
		if(InputReader.verifyRunMode("CheckOutPageValidator")){
			
		
		Object[][] data =InputReader.verifyMultiData("CheckOutPageValidator");
	
		
		return data;
		}
		return null;
	}
	@AfterMethod
	public void tearDown(ITestResult r) throws InterruptedException, IOException{
		//logout
		ScreenshotGenerator.generateScreenshot(r);
		
		HomePage.clickLogout();
	
		
	}
	
	
	
}


