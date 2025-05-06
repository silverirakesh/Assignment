package com.framework.pageobjectmodel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HyperLinkPageObject {

    // Static variable to hold the list of WebElements representing hyperlinks
    private static List<WebElement> listElement = null;

    /**
     * Fetches all hyperlink elements from the footer section of the webpage.
     * 
     * @param driver The WebDriver instance used to interact with the webpage.
     * @return A list of WebElements representing the hyperlinks.
     */
    public static List<WebElement> links(WebDriver driver) {
        // Locate all anchor tags within the footer list items
        listElement = driver.findElements(By.xpath("//li[@data-testid='footer-list-item']/a"));
        return listElement;
    }

    /**
     * Extracts valid URLs from the hyperlinks and writes them to a CSV file.
     * 
     * @param driver   The WebDriver instance used to interact with the webpage.
     * @param filePath The file path where the CSV file will be saved.
     */
    public static void writeURLsToCSV(WebDriver driver, String filePath) {
        // Fetch the list of hyperlinks
        List<WebElement> links = links(driver);

        // Extract valid URLs (non-null and non-empty)
        List<String> validURLs = links.stream()
                .map(link -> link.getDomAttribute("href"))
                .filter(url -> url != null && !url.isEmpty())
                .collect(Collectors.toList());

        // Write the valid URLs to a CSV file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("URL\n"); // Add CSV header
            for (String url : validURLs) {
                writer.append(url).append("\n"); // Write each URL to a new line
            }
            System.out.println("URLs saved to " + filePath + " successfully!");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    /**
     * Reads a CSV file containing URLs and checks for duplicate entries.
     * 
     * @param filePath The file path of the CSV file to be read.
     */
    public static void verifyDuplicateLinks(String filePath) {
        // Sets to track unique and duplicate links
        Set<String> uniqueLinks = new HashSet<>();
        Set<String> duplicateLinks = new HashSet<>();

        // Read the CSV file and identify duplicates
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstRow = true; // Flag to skip the header row
            while ((line = reader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue; // Skip the header row
                }

                // Add the line to uniqueLinks; if it already exists, add to duplicateLinks
                if (!uniqueLinks.add(line)) {
                    duplicateLinks.add(line);
                }
            }

            // Print the results
            if (duplicateLinks.isEmpty()) {
                System.out.println("No duplicate links found.");
            } else {
                System.out.println("Duplicate links detected: " + duplicateLinks);
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
