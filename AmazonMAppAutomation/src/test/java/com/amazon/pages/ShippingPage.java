package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ShippingPage extends BasePage {
 
	private String productName = "56 inch Tv";
	// *********Constructor*********
	public ShippingPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// *********Web Elements*********
	By proceedToBuyBtn_id = By.id("com.amazon.mShop.android.shopping:id/sign_in_button");
	By productName_xpath = By.xpath("//android.view.View[1]/android.view.View");
	By deliverToAddressBtn_id = By.id("com.amazon.mShop.android.shopping:id/this_address_button");
	

	public ShippingPage clickOnProceedToBuyBtn() {
		// click on Add to cart button
		click(proceedToBuyBtn_id);
		return this;
	}
	
	public BillingPage clickOnDeliverAddress() {
		// click on Add to cart button
		click(proceedToBuyBtn_id);
		return new BillingPage(driver);
	}

	public ShippingPage verifyProductName() {
		// Verify Product price
		assertTrue(productName_xpath, productName);
		return this;
	}
}