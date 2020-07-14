package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {
	public AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;

	// Constructor
	public BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}

	// Wait Wrapper Method
	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	// Click Method
	public void click(By elementBy) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).click();
	}

	// Click displayed
	public void isElementDisplayed(By elementBy) {
		Assert.assertTrue(driver.findElement(elementBy).isDisplayed(), "Logo is not displayed");
	}

	// Write Text
	public void writeText(By elementBy, String text) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
	}

	// Read Text
	public String readText(By elementBy) {
		waitVisibility(elementBy);
		return driver.findElement(elementBy).getText();
	}

	// Assert
	public void assertEquals(By elementBy, String expectedText) {
		waitVisibility(elementBy);
		Assert.assertEquals(readText(elementBy), expectedText);

	}

	// Assert true
	public void assertTrue(By elementBy, String expectedText) {
		waitVisibility(elementBy);
		Assert.assertTrue(readText(elementBy).contains(expectedText));

	}

	// Scroll down
	public void scrollDownToElementAndClick(By element) {
		TouchActions action = new TouchActions(driver);
		action.scroll(driver.findElement(element), 10, 100);
		action.perform();
		driver.findElement(element).click();
	}

	// Rotate DeviceScreen To Landscape
	public void rotateDeviceScreenToLandscape() {
		((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
	}

	// Rotate DeviceScreen To PortRait
	public void rotateDeviceScreenToPortRait() {
		((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);
	}

	// Get window size
	public void setWindowSize() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int width = ((Long) js.executeScript("return window.innerWidth || document.body.clientWidth")).intValue();

		int height = ((Long) js.executeScript("return window.innerHeight || document.body.clientHeight")).intValue();

		Dimension dimension = new Dimension(width, height);
	}

}
