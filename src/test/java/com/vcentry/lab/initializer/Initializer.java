package com.vcentry.lab.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vcentry.lab.utils.ReportOptimizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer {
	/**
	 * @author siree
	 * @data 1 aug 2022
	 * @purpose to intialize the enviroment variable
	 */
	public static ExtentReports reports;
	public static ExtentTest log;
	public static boolean isReport=true;
	
	public static Properties envprop=null;
	/**
	 * @author siree
	 * @data 18july2022
	 * @purpose to intialize the locator variable
	 */
	
	public static Properties Locatorprop=null;
	/**
	 * @author siree
	 * @throws IOException
	 * @data 18july2022
	 * @purpose to intialize env.Properties and the locator variable
	 */
	public static WebDriver wd=null;
	/**
	 * @author siree
	 * @throws IOException
	 * @data 18july2022
	 * @purpose to initialize env.Properties and the locator variable
	 */
	
	public static void intialize() throws FileNotFoundException, IOException{
		if(isReport){
			ReportOptimizer.optimizeReprort();
		
		reports=new ExtentReports("C:/Users/siree/workspace/H2_DDDTest/report/index.html");
		isReport=false;
		}
		  envprop=new Properties();
		 
		 envprop.load(new FileInputStream(new File("src/test/resources/com/vcentry/lab/config/env.properties")));
		 
		 Locatorprop= new Properties();
		 Locatorprop.load(new FileInputStream(new File("src/test/resources/com/vcentry/lab/config/locator.properties")));
		 
		 if(wd==null){
		 if (envprop.get("BROWSER").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				wd = new ChromeDriver();
			} else if (envprop.get("BROWSER").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				wd = new FirefoxDriver();
			} else if (envprop.get("BROWSER").equals("ie")) {
				WebDriverManager.iedriver().setup();
				wd = new InternetExplorerDriver();
			}
		 }
		 wd.manage().window().maximize();
		 wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wd.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		 
	}

}

