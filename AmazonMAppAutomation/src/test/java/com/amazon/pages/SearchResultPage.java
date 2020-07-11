package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SearchResultPage extends BasePage {

	// *********Constructor*********
	public SearchResultPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// *********Web Elements*********

	By searchResultProducts = By.xpath(ObjRepoProp.getProperty("searchResultProducts_xpath"));
	By secondProductLink =  By.xpath(ObjRepoProp.getProperty("secondProductLink_xpath"));

	/**
	 * Verify text scroll down to element
	 * 
	 * @param text
	 * @param searchResult
	 * @return value
	 */

	public SearchResultPage verifySearchResult(String text) {
		List<MobileElement> searchResult = driver.findElements(searchResultProducts);
		for (MobileElement result : searchResult) {
			// Verify Product description
			Assert.assertTrue(result.getText().contains(text));
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
	
}