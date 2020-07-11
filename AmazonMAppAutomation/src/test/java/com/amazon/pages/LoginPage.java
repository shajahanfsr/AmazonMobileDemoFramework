package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage extends BasePage {

	// *********Constructor*********
	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// *********Web Elements*********
	By useremailBy = By.xpath(ObjRepoProp.getProperty("useremailBy_xpath"));
	By passwordBy = By.xpath(ObjRepoProp.getProperty("passwordBy_xpath"));
	By loginButtonBy = By.xpath(ObjRepoProp.getProperty("loginButtonBy_xpath"));
	By continueBotton = By.xpath(ObjRepoProp.getProperty("continueBotton_xpath"));
	
	/**
	 * Login to Amazon app
	 * 
	 * @param username
	 * @param password
	 * @return HomePage
	 */
	public HomePage loginToApplication(String username, String password) {
		// Enter Username(Email)
		writeText(useremailBy, username);
		// click on continue button
		click(continueBotton);
		// Enter Password
		writeText(passwordBy, password);
		// Click Login Button
		click(loginButtonBy);
		
		return new HomePage(driver);
	}

}