package com.framework.hooks;



import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {
    

	private static WebDriver driver;
 
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        setDriver(getDriver(browser));
        System.out.println("Browser Launched: " + browser);

        // Start Extent Test for the scenario

    }

    @After
    public void teardown() {
   
        if (getDriver() != null) {
           // driver.quit();
            //driver = null; // Reset driver instance
            System.out.println("Browser Closed");
        }

        // Flush Extent Reports
 
    }

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Hooks.driver = driver;
	}

  
}
