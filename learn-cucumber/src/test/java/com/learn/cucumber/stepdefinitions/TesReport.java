package com.learn.cucumber.stepdefinitions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TesReport {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		ExtentReports extentReports = new ExtentReports();
		File file = new File("SparkReport\\Spark.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		sparkReporter.config().setTheme(Theme.DARK);
		extentReports.setSystemInfo("Browser", "Ulla");
		extentReports.attachReporter(sparkReporter);
		extentReports.createTest("Test 1", "Test desc").assignAuthor("Nasruddin").assignCategory("Smoke")
				.assignDevice("Chrom 99").pass("This is passed");
		extentReports.flush();
		driver.quit();
	}

}
