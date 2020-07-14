package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ReviewPage extends BasePage {

	// *********Constructor*********
	public ReviewPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public ReviewPage clickOnSubmitBtn() {
		// click on Add to cart button
		click(proceedToBuyBtn_id);
		return this;
	}
	
	public ReviewPage verifyConfirmatinMsg() {
		// Verify Product price
		isElementDisplayed(confirmationMessage_xpath);
		return this;
	}
	

	// *********Web Elements*********
	By proceedToBuyBtn_id = By.id("com.amazon.mShop.android.shopping:id/continue_button");
	By confirmationMessage_xpath = By.xpath("//android.view.View/android.view.View[5]/android.view.View[6]");

}