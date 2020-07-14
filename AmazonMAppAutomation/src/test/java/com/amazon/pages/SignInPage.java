package com.amazon.pages;

import static com.amazon.testUtils.PropertyFileReader.ObjRepoProp;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
 
public class SignInPage extends BasePage{ 
	
	//*********Constructor*********
    public SignInPage (AppiumDriver<MobileElement> driver) {
        super(driver);
    }
 
  
    /**
     * Navigate to login page
     * @return LoginPage
     */
    public LoginPage goToLoginPage (){
        click(signInButtonBy);
        return new LoginPage(driver);
    }
    

    //*********Web Elements*********
    By signInButtonBy = By.id("com.amazon.mShop.android.shopping:id/sign_in_button");
   
    }