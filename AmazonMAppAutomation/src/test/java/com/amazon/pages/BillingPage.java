package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BillingPage extends BasePage {

	// *********Constructor*********
	public BillingPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	/**
	 * Enter billing details
	 * @param name
	 * @param cardName
	 * @param cvv
	 * @return ReviewPage
	 */
	public ReviewPage enterBillingDetailsAndClickOnProceedButton(String name, String cardName,String cvv) {
			writeText(cardNameTextField, name);
			writeText(cardNumTextField, cardName);
			writeText(cvvTextField, cvv);
			click(continueBotton);
			return new ReviewPage(driver);
		}
		
		
		// *********Web Elements*********
		By cardNameTextField = By.id("com.amazon.mShop.android.shopping:id/text1");
		By cardNumTextField = By.xpath("//android.view.View/descendant::android.view.View[6]");
		By cvvTextField = By.id("com.amazon.mShop.android.shopping:id/text_bill");
		By continueBotton = By.id("com.amazon.mShop.android.shopping:id/continue_button");
		By submitButton = By.id("com.amazon.mShop.android.shopping:id/submit_button");

}