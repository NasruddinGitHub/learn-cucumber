package com.learn.cucumber.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDef {
	WebDriver driver;

	@Given("I am on registration page")
	public void i_am_on_registration_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.truckdues.com/app/#register");
	}

	@When("I register with the existing email id in the database")
	public void i_register_with_the_existing_email_id_in_the_database() throws InterruptedException {
		driver.findElement(By.id("txtFirstName")).sendKeys("FirstName");
		driver.findElement(By.id("txtLastName")).sendKeys("LastName");
		driver.findElement(By.id("txtEmailId")).sendKeys("nasruddin.shaik@jeevantechnologies.com");
		driver.findElement(By.id("txtPhone")).sendKeys("7452145874");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtConfirm")).sendKeys("123456");
		Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("registration should not be successful")
	public void registration_should_not_be_successful() {
		String currentUrl = driver.getCurrentUrl();
		if (!currentUrl.contains("register")) {
			Assert.fail("Registration has been successful");
		}
	}

	@Then("I see field level error message at email field")
	public void i_see_field_level_error_message_at_email_field() {
		String errorMessageExistingEmail = driver.findElement(By.xpath("//span[text()='Email already exist']"))
				.getText();
		Assert.assertEquals(errorMessageExistingEmail, "Email already exist");
		Assert.fail();
	}

	@Given("I test dependency injection")
	public void i_test_dependency_injection() {

	}

}
