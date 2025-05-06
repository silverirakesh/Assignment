package com.framework.stepdefinitions.dp1;


import com.framework.common.UIHelpers;
import com.framework.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.pageobjectmodel.SlidePageObjectModel;


public class SlidePages {
	private WebDriver driver;
    List<WebElement> slides;
    private Actions actions;
    
    SlidePageObjectModel slidePageObjectModel = new SlidePageObjectModel();
    
    public SlidePages() {
		this.driver = Hooks.getDriver("chrome"); // Use Hooks.driver
		if (this.driver == null) {
		}
		this.actions = new Actions(driver);
	}
  
    @Given("I am on the DP1 home page")
    public void i_am_on_the_dp1_home_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
    	UIHelpers.navigateToURL(driver, "https://www.nba.com/sixers");
    }

    @When("I locate the slides below the Tickets Menu")
    public void i_locate_the_slides_below_the_tickets_menu() {
     	   slides = driver.findElements(SlidePageObjectModel.TABLIST_BUTTONS);
           System.out.println("Total slides: " + slides.size());
    }

    @When("I should see exactly {string} slides")
    public void i_should_see_exactly_slides(String string) {
    	 int expectedCount = 5; // Set expected slide count
     	 Assert.assertTrue(expectedCount == slides.size(), "Expected slide count should be greater than 0");
    }

    @When("the title should match expected test data")
    public void the_title_should_match_expected_test_data() throws InterruptedException {
    	Thread.sleep(2000); // Wait for the slides to load
    	List<String> expectedTitles = new ArrayList<>();
    	List<WebElement> slideTitleCount = driver.findElements(SlidePageObjectModel.TABLIST_BUTTONS);
    	for (int i = 1; i <= slideTitleCount.size(); i++) {
    		String titleName = String.format(SlidePageObjectModel.TITLE, i);
            String slideTitleName = slideTitleCount.get(i - 1).findElement(By.xpath(titleName)).getText().trim();
            System.out.println("Slide Title Name: " + slideTitleName);
            expectedTitles.add(slideTitleName);
    	}	
    }

    @When("the duration should match expected values")
    public void the_duration_should_match_expected_values() {
    	List<WebElement> durationSlides = driver.findElements(SlidePageObjectModel.TABLIST_BUTTONS);
    	for (int i = 1; i <= durationSlides.size(); i++) {
    		SlidePageObjectModel.verifySlideTiming(i, driver);}
    	
    }
    
    
}
