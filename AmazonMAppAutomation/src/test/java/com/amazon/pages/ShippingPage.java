package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ShippingPage extends BasePage {
 
	private static final String productName = "56 inch Tv";
	
	// *********Constructor*********
	public ShippingPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	/**
	 * click on Add to cart button
	 * @return ShippingPage
	 */

	public ShippingPage clickOnProceedToBuyBtn() {
		click(proceedToBuyBtn_id);
		return this;
	}
	
	/**
	 * click on Add to cart button
	 * @return BillingPage
	 */
	public BillingPage clickOnDeliverAddress() {
		click(proceedToBuyBtn_id);
		return new BillingPage(driver);
	}

	/**
	 * Verify Product price
	 * @return
	 */
	public ShippingPage verifyProductName() {
	   assertText(productName_xpath, productName);
		return this;
	}
	
	// *********Web Elements*********
		By proceedToBuyBtn_id = By.id("com.amazon.mShop.android.shopping:id/sign_in_button");
		By productName_xpath = By.xpath("//android.view.View[1]/android.view.View");
		By deliverToAddressBtn_id = By.id("com.amazon.mShop.android.shopping:id/this_address_button");
		
}