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

		// *********Web Elements*********
		By cardNameTextField_xpath = By.xpath(ObjRepoProp.getProperty("useremailBy_xpath"));
		By cardNumTextField_xpath = By.xpath(ObjRepoProp.getProperty("passwordBy_xpath"));
		By cvvTextField_xpath = By.xpath(ObjRepoProp.getProperty("loginButtonBy_xpath"));
		By continueBotton_id = By.id(ObjRepoProp.getProperty("continueBotton_xpath"));
		By submitButton_id= By.id(ObjRepoProp.getProperty("continueBotton_xpath"));
		
		
		public ReviewPage enterBillingDetailsAndClickOnProceedButton(String name, String cardName,String cvv) {
			// Enter name
			writeText(cardNameTextField_xpath, name);
			// Enter ncard numberame
			writeText(cardNumTextField_xpath, cardName);
			// Enter ncard numberame
			writeText(cvvTextField_xpath, cvv);
			// click on continue button
			click(continueBotton_id);
						
			return new ReviewPage(driver);
		}

	
}