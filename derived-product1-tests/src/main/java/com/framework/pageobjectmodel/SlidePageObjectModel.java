package com.framework.pageobjectmodel;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SlidePageObjectModel {
	
	public static final By TABLIST_BUTTONS = By.xpath("//div[@role='tablist']/button");
	public static final String TITLE = "(//div[@role='tablist']/button/div[contains(@class, 'ButtonTitle')])[%d]";
	
	
    public static void verifySlideTiming(int i, WebDriver driver) {
        WebElement firstSlide = driver.findElement(By.xpath("(//div[@role='tablist']/button/div[contains(@class, 'ButtonTitle')])["+i+"]/parent::button"));

        Instant startTime = null;
		Instant endTime = null;

		// Wait for the first slide to be selected
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.attributeToBe(firstSlide, "aria-selected", "true"));

		// Check the aria-selected attribute continuously
		while (true) { // Continuously check until state changes
        	String ariaSelected = firstSlide.getDomAttribute("aria-selected");

            if ("true".equals(ariaSelected) && startTime == null) {
                startTime = Instant.now();
                System.out.println("Slide started at: " + startTime);
            }

            if ("false".equals(ariaSelected) && startTime != null) {
                endTime = Instant.now();
                System.out.println("Slide ended at: " + endTime);
                break;
            }
        }

        if (startTime != null && endTime != null) {
            long duration = endTime.toEpochMilli() - startTime.toEpochMilli();
            System.out.println("Slide duration for Slide " +i+": " + duration / 1000 + " seconds");
        }
    }

}
