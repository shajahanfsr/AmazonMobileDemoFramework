package com.amazon.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchResultPage;
import com.amazon.pages.SignInPage;
import com.amazon.testUtils.ExcelReader;

public class TC_1_SearchAddProductToShoppingCartAsExistingUser extends BaseTest {
	SignInPage signInPage;
	HomePage homepage;
	SearchResultPage searchResultPage;
	ProductPage productPage;
	String password, username;
	// Below value can be read direct from Database using Jdbc links
	String productName = "56 inch Tv", price = "54999", count = "1";

	/*
	 * LoginTo application with valid credentials
	 */
	@Test(description = "Step1:loginToApplication", priority = 1)
	public void loginToApplication() throws Exception {

		// *************PAGE INSTANTIATIONS*************
		signInPage = new SignInPage(driver);
		username = ExcelReader.getCellData("LoginDetails", "User_email", 2);
		password = ExcelReader.getCellData("LoginDetails", "Login_Password", 2);

		// *************PAGE METHODS********************
		homepage = signInPage.goToLoginPage().loginToApplication(username, password);
		homepage.verifyHomePageLogo();
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
		searchResultPage = homepage.searchForProduct(productName);
		searchResultPage.verifySearchResult(productName);
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
		productPage.verifyProductPrice(price);
		// Scrolling till element and click
		productPage.scrollAndClickOnAddtoCartButton();
		productPage.verifyShoppingBagIconAndCount(count);
		log.info("Successfully searched for products \n");
		Reporter.log("<p>Successfully searched for products");
	}
}
