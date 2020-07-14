package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProductPage extends BasePage {
	private static final String  price = "54999" ,count = "1";;

	// *********Constructor*********
	public ProductPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	/**
	 * Verify text scroll down to element
	 * 
	 * @param text
	 * @param searchResult
	 * @return value
	 */

	public ProductPage verifyProductPrice() {
		// Verify Product price
		assertText(productPriceText_xpath,price);
		return this;
	}
	
	public ProductPage scrollAndClickOnAddtoCartButton() {
		// click on Add to cart button
		scrollDownToElementAndClick(addToCartBtn_id);
		return this;
	}
	
	public ProductPage verifyShoppingBagIconAndCount() {
		// Verify Product price
		assertText(shoppingBagCount_id, count);
		isElementDisplayed(shoppingCartIcon_xpath);
		return this;
	}
	
	public ShippingPage clickShopiingBagIcon() {
		// Verify Product price
		click(shoppingCartIcon_xpath);
		return new ShippingPage(driver);
	}
	

	// *********Web Elements*********
	By addToCartBtn_id = By.id("add-to-cart-button");
	By productPriceText_xpath = By.xpath("//android.view.View[1]/android.view.View/android.view.View/android.widget.EditText\r\n");
	By shoppingCartIcon_xpath=By.xpath("//android.widget.ImageView[@content-desc='Cart']\r\n");
	By shoppingBagCount_id=By.id("com.amazon.mShop.android.shopping:id/action_bar_cart_count");

	
	

}