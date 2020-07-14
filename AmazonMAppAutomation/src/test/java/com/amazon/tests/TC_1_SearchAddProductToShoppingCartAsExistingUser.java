package com.amazon.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.amazon.pages.BillingPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ReviewPage;
import com.amazon.pages.SearchResultPage;
import com.amazon.pages.ShippingPage;
import com.amazon.pages.SignInPage;
import com.amazon.testUtils.ExcelReader;

public class TC_1_SearchAddProductToShoppingCartAsExistingUser extends BaseTest {
	
	SignInPage signInPage;
	HomePage homepage;
	SearchResultPage searchResultPage;
	ProductPage productPage;
	ShippingPage shippingPage;
	ReviewPage reviewPage;
	BillingPage billingPage;
	String password, username,name,cardNum,cvv;
	

	/**
	 * LoginTo application with valid credentials
	 * @throws Exception
	 */
	@Test(description = "Step1:loginToApplication", priority = 1)
	public void loginToApplication() throws Exception {

		// *************PAGE INSTANTIATIONS*************
		signInPage = new SignInPage(driver);
		username = ExcelReader.getCellData("LoginDetails", "User_email", 2);
		password = ExcelReader.getCellData("LoginDetails", "Login_Password", 2);

		// *************PAGE METHODS********************
		homepage.rotateDeviceScreenToLandscape();
		homepage.setWindowSize();
		homepage = signInPage.goToLoginPage().loginToApplication(username, password);
		homepage.verifyHomePageLogo();
		homepage.rotateDeviceScreenToPortRait();
		log.info("Successfully login to application \n");
		Reporter.log("<p> Successfully login to application");
	}

	/**
	 * This method id for SearchForProductAndNavigateProductsPage
	 * 
	 * @throws Exception
	 */
	@Test(description = "Step2:SearchForProductAndNavigateProductsPage", priority = 2)
	public void SearchForProductAndNavigateProductsPage() throws Exception {
		searchResultPage = homepage.searchForProduct();
		searchResultPage.verifySearchResult();
		log.info("Successfully searched for products \n");
		Reporter.log("<p>Successfully searched for products");
	}

	/**
	 * Add product to shopping cart
	 * 
	 * @throws Exception
	 */

	@Test(description = "Step3:Add product to shopping cart", priority = 3)
	public void addProductToShoppingCart() throws Exception {

		productPage = searchResultPage.selectSecondProductAndNavigateToProductPage();
		// Price can be read direct from database using jdbc link
		productPage.verifyProductPrice();
		// Scrolling till element and click
		productPage.scrollAndClickOnAddtoCartButton();
		productPage.verifyShoppingBagIconAndCount();
		log.info("Successfully searched for products \n");
		Reporter.log("<p>Successfully searched for products");
	}
	
	@Test(description = "Step4:Click on shopping cart and Proceed to shippingPage", priority = 4)
	public void clickOnShoppingCartAndProceedToShippingPage() throws Exception {
		
		shippingPage=productPage.clickShopiingBagIcon();
		shippingPage.verifyProductName();
		shippingPage.clickOnProceedToBuyBtn();
		billingPage=shippingPage.clickOnDeliverAddress();
		log.info("Successfully navigated bulling page \n");
		Reporter.log("<p>Successfully navigated bulling page");
	}
	
	@Test(description = "Step5:EnterBillingDetailsPlaceOrder", priority = 5)
	public void enterBillingDetailsPlaceOrder() throws Exception {
		name = ExcelReader.getCellData("BillingDetails", "Name", 2);
		cardNum = ExcelReader.getCellData("BillingDetails", "CardNumber", 2);
		cvv = ExcelReader.getCellData("BillingDetails", "CVV", 2);
		
		reviewPage=billingPage.enterBillingDetailsAndClickOnProceedButton(name, cardNum, cvv);
		reviewPage.clickOnSubmitBtn();
		reviewPage.verifyConfirmatinMsg();
	}
}
