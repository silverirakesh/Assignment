package com.framework.stepdefinitionsdp2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		tags = "@TC4", plugin = { "pretty", "html:target/cucumber-html-report",
				"json:target/cucumber.json" }, features = "src/test/resources", glue = "com.framework.stepdefinitionsdp2", monochrome = true)
public class DP2TestRunner extends AbstractTestNGCucumberTests {

}
