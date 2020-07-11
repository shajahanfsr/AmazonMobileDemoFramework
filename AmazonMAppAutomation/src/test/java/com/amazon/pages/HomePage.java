package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BasePage {
	// *********Constructor*********
	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// *********Web Elements*********
	By searchTextField = By.id(ObjRepoProp.getProperty("searchTextField_id"));
	By productSearchList = By.xpath(ObjRepoProp.getProperty("productSearchList_xpath"));
	By homePagelogo = By.id(ObjRepoProp.getProperty("homePagelogo_id"));

	// *********Page Methods*********

	/**
	 * Navigate to login page
	 * 
	 * @return LoginPage
	 */
	public SearchResultPage searchForProduct(String productName) {
		// CLick on search field
		click(searchTextField);
		// Enter product name
		writeText(searchTextField, productName);
		// SelectProduct name from list
		click(productSearchList);
		return new SearchResultPage(driver);
	}

	public void verifyHomePageLogo() {
		Assert.assertTrue(isElementDisplayed(homePagelogo), "Logo is not displayed");
	}

}