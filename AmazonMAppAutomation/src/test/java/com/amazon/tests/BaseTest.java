package com.amazon.tests;

import java.io.FileInputStream;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {

	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static Logger log;
	FileInputStream objfile;

	@BeforeClass
	public void setup() throws Exception {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\AmazonMAppAutomation\\Resouces\\log4j.properties");
		// For logging
		log = Logger.getLogger(this.getClass().getName());
		//Auto strating appium from cmd 
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		log.info("*************Appium started***********");
		DesiredCapabilities caps = new DesiredCapabilities();
		//Reading properties -Darguments from Maven  line
		caps.setCapability("deviceName", System.getProperty("deviceName"));
		caps.setCapability("udid", System.getProperty("udid"));
		caps.setCapability("platformName", System.getProperty("platformName"));
		caps.setCapability("platformVersion", System.getProperty("platformVersion"));
		caps.setCapability("skipUnlock", "true");		
		caps.setCapability("app", System.getProperty("user.dir")+"/Test/Resources/Amazon_shopping.apk");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("autoAcceptAlerts", "true");
		caps.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		caps.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		caps.setCapability("noReset", "false");
		
		// Create a Android Driver driver. All test classes use this.
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
