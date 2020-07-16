package com.amazon.pages;

import org.openqa.selenium.By;

import com.amazon.testUtils.ExcelReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BasePage {

	private static final String productName = ExcelReader.getCellData("LoginDetails", "ProductName", 2);

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
			"//android.widget.ListView/descendant::android.widget.TextView");
	By homePagelogo = By.id("accActivation.homePagelogo_id");

}