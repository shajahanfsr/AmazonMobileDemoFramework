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

	/**
	 * Login to Amazon app
	 * 
	 * @param username
	 * @param password
	 * @return HomePage
	 */
	public HomePage loginToApplication(String username, String password) {
		writeText(useremailBy, username);
		click(continueBotton);
		writeText(passwordBy, password);
		click(loginButtonBy);
		return new HomePage(driver);
	}
	
	

	// *********Web Elements*********
	By useremailBy = By.xpath("//android.view.View[2]/descendant::android.widget.EditText");
	By passwordBy = By.xpath("//android.webkit.WebView/descendant::android.widget.EditText");
	By loginButtonBy = By.xpath("//android.view.View/descendant::android.widget.Button");
	By continueBotton = By.xpath("//android.webkit.WebView/descendant::android.widget.Button");
	
	

}