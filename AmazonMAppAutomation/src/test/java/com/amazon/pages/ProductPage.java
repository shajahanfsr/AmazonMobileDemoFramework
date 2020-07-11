package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProductPage extends BasePage {

	// *********Constructor*********
	public ProductPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// *********Web Elements*********
	By addToCartBtn_id = By.id(ObjRepoProp.getProperty("addToCartBtn_id"));
	By productPriceText_xpath = By.xpath(ObjRepoProp.getProperty("productPriceText_xpath"));
	By shoppingCartIcon_xpath=By.xpath(ObjRepoProp.getProperty("shoppingCartIcon_xpath"));
	By shoppingBagCount_id=By.id(ObjRepoProp.getProperty("shoppingCartIcon_xpath"));

	/**
	 * Verify text scroll down to element
	 * 
	 * @param text
	 * @param searchResult
	 * @return value
	 */

	public ProductPage verifyProductPrice(String text) {
		// Verify Product price
		Assert.assertTrue(readText(productPriceText_xpath).contains(text));
		return this;
	}
	
	public ProductPage scrollAndClickOnAddtoCartButton() {
		// click on Add to cart button
		scrollDownToElementAndClick(addToCartBtn_id);
		return this;
	}
	
	public ProductPage verifyShoppingBagIconAndCount(String text) {
		// Verify Product price
		Assert.assertTrue(readText(shoppingBagCount_id).contains(text));
		Assert.assertTrue(isElementDisplayed(shoppingCartIcon_xpath), "Shopping bag icon is not displayed");
		return this;
	}
	
	

}