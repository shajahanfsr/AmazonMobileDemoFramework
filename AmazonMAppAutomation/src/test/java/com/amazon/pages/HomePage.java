package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BasePage {

	private static final String productName = "56 inch Tv";

	// *********Constructor*********
	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	// *********Page Methods*********
	/**
	 * Navigate to login page
	 * 
	 * @return LoginPage
	 */
	public SearchResultPage searchForProduct() {
		// CLick on search field
		click(searchTextField);
		// Enter product name
		writeText(searchTextField, productName);
		// SelectProduct name from list
		click(productSearchList);
		return new SearchResultPage(driver);
	}

	/**
	 * verify HomePage Logo
	 */
	public void verifyHomePageLogo() {
		isElementDisplayed(homePagelogo);
	}
	

	// *********Web Elements*********
	By searchTextField = By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text");
	By productSearchList = By.xpath(
			"//android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView");
	By homePagelogo = By.id("accActivation.homePagelogo_id");

}