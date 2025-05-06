package com.framework.stepdefinitionsdp2;

import com.framework.hooks.Hooks;
import com.framework.pageobjectmodel.HyperLinkPageObject;
import com.framework.utilities.JsonConfigReader;
import com.framework.common.UIHelpers;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.interactions.Actions;

public class HyperlinksPages {
	private WebDriver driver;
	private Actions actions;

	 // Path to your JSON config file
	
    JsonConfigReader jsonConfigReader = new JsonConfigReader();
    File jsonFile = new File("testdata.json");
    

	HyperLinkPageObject hyperLinkPageObject = new HyperLinkPageObject();

	// Default Constructor
	public HyperlinksPages() throws IOException {
		String browser = jsonConfigReader.getValueFromJson(jsonFile, "browser");
		this.driver = Hooks.getDriver(browser); // Use Hooks.driver
		if (this.driver == null) {
		}
		this.actions = new Actions(driver);

	}

	@Given("User navigates to the DP2 home page")
	public void user_navigates_to_the_dp2_home_page() throws InterruptedException {
		UIHelpers.navigateToURL(driver, "https://www.nba.com/sixers/"); // Navigate to the specified URL
	}

	@When("User extracts all hyperlinks from the footer into a CSV file")
	public void user_extracts_all_hyperlinks_from_the_footer_into_a_csv_file() {
		HyperLinkPageObject.writeURLsToCSV(driver, "FooterLinks.csv");
	}

	@Then("User verifies if any duplicate hyperlinks are present in the report")
	public void user_verifies_if_any_duplicate_hyperlinks_are_present_in_the_report() {
		HyperLinkPageObject.verifyDuplicateLinks("Footerlinks.csv");

	}

}