package com.framework.pageobjectmodel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.framework.common.UIHelpers;

public class JacketsPageObject {
	
	public final String NEWSG = "(//time/span)[%d]";
	public final String NF = ("(//ul[@class='flex flex-wrap sm:-mx-3.75 xl:-mx-5 divide-y sm:divide-y-0'])[1]/*");
	public final By NEWSFEAT = By.xpath("//nav[@id='nav-dropdown-desktop-1058447']/ul/li[2]/a");
	public final By SHOPE = By.xpath("//a[@class=' _link_ob2qz_1 text-2sm']");
	public final By MOUSEOVER = By.xpath("//div[@class='p-2 absolute right-3 hover:cursor-pointer']");
	public final String TXPTH = "(//div[@class='product-card-title'])[%d]";
	public final String XXPTH = "(//div[@class='price-row']//span[@class='lowest'])[%d]";
	public final By JCKT = By.xpath("//div[@class='grid grid-small-2-medium-3 row small-up-2 medium-up-3']/*");
	public final By NBTN = By.xpath("(//li[@class='next-page'])[1]");
	public final By CLOSEPOP =  By.xpath("//div[@class='p-2 absolute right-3 hover:cursor-pointer']");
	public final By SHOP = By.xpath("//span[contains(text(),'Shop')]");
	public final By SHOPMEN = By.linkText("Men\'s");
	
	
	public void CountFilteredNewsDates(List<String> alist) {
		
		

		List<String> newsDates = alist;
		int sum = 0;
		{

			for (String item : newsDates) {
				String numberOnly = item.replaceAll("\\D+", ""); // Extract numeric part
				if (!numberOnly.isEmpty()) {
					int num = Integer.parseInt(numberOnly);
					if (num > 3) { // Sum numbers strictly greater than 3
						sum += num;
					}
				}
			}

			System.out.println("Total sum of values where number > 3: " + sum);
		}
	}
	
	public void writeToFile(WebDriver driver, OutputStreamWriter writer) throws IOException {
		try {
			while (true) { // Loop through pagination

				// Find all jacket elements in the grid
				List<WebElement> jackets = driver.findElements(JCKT);

				// Loop through all jacket elements
				for (int i = 1; i <= jackets.size(); i++) { // Start index from 1 for XPath positioning
					try {
						// Dynamic XPath for price
						String priceXPath = String.format(XXPTH, i);
						String price = jackets.get(i - 1).findElement(By.xpath(priceXPath)).getText().trim();

						// Dynamic XPath for title
						String titleXPath = String.format(TXPTH, i);
						String title = jackets.get(i - 1).findElement(By.xpath(titleXPath)).getText().trim();

						// Dynamic XPath for top seller
						try {
							WebElement topSellerElement = driver
									.findElement(By.xpath(titleXPath + "/following-sibling::div/div"));
							String topSeller = topSellerElement.getText().trim();

							writer.write(price + " | " + title + " | " + topSeller + "\n");
						} catch (Exception e) {
							writer.write(price + " | " + title + "\n"); // If topSeller is missing, write without it
						}

					} catch (Exception e) {
						System.out.println("Skipping item " + i + " due to missing elements.");
					}
				}
				WebElement nextButton = driver.findElement(NBTN);

				if (nextButton.isDisplayed()) { // Check if "Next" button is visible
					nextButton.click(); // Click the button
					Thread.sleep(5000); // Wait for the next page to load
				} else {
					System.out.println("No more pages to navigate.");
				}

			}
		} catch (Exception e) {
			System.out.println("Error during pagination: " + e.getMessage());
		} finally {
			writer.flush();
			writer.close();
		}
	}

}
