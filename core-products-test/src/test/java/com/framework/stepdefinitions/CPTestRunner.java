package com.framework.stepdefinitions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

			 tags = "@TC2", 
		
		plugin = { "pretty", "html:target/cucumber-html-report",
				"json:target/cucumber.json" }, features = "src/test/resources", glue = "com.framework.stepdefinitions", monochrome = true)
public class CPTestRunner extends AbstractTestNGCucumberTests {

}
