package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SearchResultPage extends BasePage {
	
	private static final String productName = "56 inch Tv";

	// *********Constructor*********
	public SearchResultPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	
	/**
	 * Verify text scroll down to element
	 * 
	 * @param text
	 * @param searchResult
	 * @return value
	 */

	public SearchResultPage verifySearchResult() {
		List<MobileElement> searchResult = driver.findElements(searchResultProducts);
		for (MobileElement result : searchResult) {
			// Verify Product description
			assertTrue(result,productName);
			// Scroll down
			scrollDownToElementAndClick(secondProductLink);
		}
		return this;
	}

	/**
	 * select Second Product And Navigate To ProductPage
	 * 
	 * @return ProductPage
	 */
	public ProductPage selectSecondProductAndNavigateToProductPage() {
		click(secondProductLink);
		return new ProductPage(driver);
	}
	

	// *********Web Elements*********

	By searchResultProducts = By.xpath("//android.widget.ListView/android.widget.LinearLayout[2]");
	By secondProductLink =  By.xpath("//android.widget.ListView/android.widget.LinearLayout[2]");

	
}