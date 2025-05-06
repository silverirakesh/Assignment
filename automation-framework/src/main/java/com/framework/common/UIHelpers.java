package com.framework.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.hooks.Hooks;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import io.cucumber.core.logging.Logger;

import java.util.List;
import java.util.Map;

public class UIHelpers {

	WebDriver driver = Hooks.getDriver();

	public static void setDriver(WebDriver driver) {
		Hooks.setDriver(driver);
	}

	public static WebDriver getDriver() {
		return Hooks.getDriver();
	}

	public static void quitDriver() {
		WebDriver driver = Hooks.getDriver();
		if (driver != null) {
			driver.quit();
			Hooks.setDriver(null); // Reset driver instance
			System.out.println("Browser Closed");
		}
	}

	public static void navigateToURL(WebDriver driver, String url) {
		driver.get(url); // Navigate to the specified URL
		System.out.println("Navigated to: " + url);
	}

	public static void waitForElementToBeVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementToBeClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void clickElement(WebDriver driver, By locator) {
		waitForElementToBeClickable(driver, locator);
		driver.findElement(locator).click();
	}

	public static void enterText(WebDriver driver, By locator, String text) {
		waitForElementToBeVisible(driver, locator);
		driver.findElement(locator).sendKeys(text);
	}

	public static String getElementText(WebDriver driver, By locator) {
		waitForElementToBeVisible(driver, locator);
		return driver.findElement(locator).getText();
	}
	

	

	
	}
	

	



	
