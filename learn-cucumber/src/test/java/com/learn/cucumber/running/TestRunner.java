package com.learn.cucumber.running;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = { "com.learn.cucumber.stepdefinitions" }, features = {
		"src/test/resources/application-features" }, tags = "@Tagss", plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner extends AbstractTestNGCucumberTests {

	static {
		System.setProperty("extent.reporter.spark.out", "Spark Report/" + System.getProperty("browser") + ".html");
		System.setProperty("systeminfo.browser", System.getProperty("browser"));
		System.setProperty("systeminfo.blahblahblah", "blahblahblahassad");
		System.out.println("Test");
	}
}
