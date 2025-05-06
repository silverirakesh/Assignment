package com.framework.stepdefinitions.dp1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		tags = "@TC3", plugin = { "pretty", "html:target/cucumber-html-report",
				"json:target/cucumber.json" }, features = "src/test/resources", glue = "com.framework.stepdefinitions.dp1", monochrome = true)
public class DP1TestRunner extends AbstractTestNGCucumberTests {

}