package com.framework.stepdefinitions;

import com.framework.common.UIHelpers;
import com.framework.hooks.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.framework.pageobjectmodel.JacketsPageObject;

public class JacketPages {
	private WebDriver driver;
	private Actions actions;
	private static final String FILE_PATH = "src/test/resources/JacketDetails2.txt";
	List<WebElement> newsandfeatures;

	JacketsPageObject JacketsPageObject = new JacketsPageObject();

	// Default Constructor
	public JacketPages() {
		this.driver = Hooks.getDriver("chrome"); // Use Hooks.driver
		if (this.driver == null) {
		}
		this.actions = new Actions(driver);

	}

	@Given("User navigates to the Mens Jackets section")
	public void navigateToJackets() throws InterruptedException {
		UIHelpers.navigateToURL(driver, "https://www.nba.com/warriors");
		Thread.sleep(5000);
		WebElement element = driver.findElement(JacketsPageObject.CLOSEPOP);
		element.click();
		// Locate the "Shop" element
		WebElement shopElement = driver.findElement(JacketsPageObject.SHOP);
		actions.moveToElement(shopElement).perform();

		driver.findElement(JacketsPageObject.SHOPMEN).click();

		Set<String> windowHandles = driver.getWindowHandles();
		String originalTab = driver.getWindowHandle();

		// Switch to the newly opened tab
		for (String handle : windowHandles) {
			if (!handle.equals(originalTab)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		Thread.sleep(20000);
		WebElement jacketsLink = driver.findElement(By.xpath("//a[contains(@class, 'facet-link')]//span[contains(text(),'Jackets')]"));
		jacketsLink.click();
	}

	@When("User extracts jacket details from all paginated pages")
	public void extractJacketDetails() throws IOException {
		FileWriter writer = new FileWriter("src/test/resources/JacketDetails2.txt");
		JacketsPageObject.writeToFile(driver, writer);	
	}

	@Then("User saves jacket details in a text file and attaches it to the report")
	public void attachReport() throws IOException {
		System.out.println("Jacket details saved to JacketDetails.txt");
		// UIHelpers.attachTextFileToAllure(FILE_PATH);

	}

	@Given("User is on the CP home page")
	public void user_is_on_the_cp_home_page() {
		UIHelpers.navigateToURL(driver, "https://www.nba.com/warriors");
	}

	@When("User clicks on New & Features")
	public void user_clicks_on_new_features() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(10000);

		WebElement element = driver.findElement(JacketsPageObject.MOUSEOVER);
		element.click();
		Thread.sleep(10000);

		// Locate the "Shop" element
		WebElement shopElement = driver.findElement(By.xpath("//a[@class=' _link_ob2qz_1 text-2sm']"));
		actions.moveToElement(shopElement).perform();
		actions.moveByOffset(50, 50).perform();
		Thread.sleep(5000);

		WebElement newsn = driver.findElement(JacketsPageObject.NEWSFEAT);
		newsn.click();
		Thread.sleep(10000);

	}

	@Then("User counts the total number of video feeds available")
	public void user_counts_the_total_number_of_video_feeds_available() {
		// Write code here that turns the phrase above into concrete actions
		newsandfeatures = driver.findElements(
				By.xpath(JacketsPageObject.NF));
		System.out.println("Total number of video feeds available: " + newsandfeatures.size());
	}

	@Then("User counts the video feeds that are present on the page which are greater than three days")
	public void user_counts_the_video_feeds_that_are_present_on_the_page_which_are_greater_than_three_days() {
		for (int i = 1; i <= newsandfeatures.size(); i++) {
			String newsGreater = String.format(JacketsPageObject.NEWSG, i);
			String newsDate = newsandfeatures.get(i - 1).findElement(By.xpath(newsGreater)).getText().trim();
			// removeHoursAndCountDays(List.of(newsDate));
			List<String> alist = new ArrayList<>();
			alist.add(newsDate);
			alist.removeIf(text -> text.contains("h"));
			JacketsPageObject.CountFilteredNewsDates(alist);
		}
	}
}
