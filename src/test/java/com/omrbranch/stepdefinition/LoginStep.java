package com.omrbranch.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.omrbranch.facotry.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

	WebDriver driver=DriverFactory.getDriver();

	@Given("User enters a valid email address {string} in the email field")
	public void user_enters_a_valid_email_address_in_the_email_field(String emailAddress) {

		driver.findElement(By.id("email")).sendKeys(emailAddress);
	}

	@When("User enters a valid password {string} in the password field")
	public void user_enters_a_valid_password_in_the_password_field(String password) {

		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {

		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Then("User should be successfully logged in")
	public void user_should_be_successfully_logged_in() {

		Assert.assertTrue(driver.findElement(By.xpath("//a[@data-testid='username']")).isDisplayed());
	}

//	@When("User navigates to Hotel page")
//	public void User_navigates_to_Hotel_page() {
//
//		driver.findElement(By.xpath("//img[@alt='hotel booking']")).click();
//	}

	@Given("User enters a Invalid email address {string} in the email field")
	public void user_enters_a_invalid_email_address_in_the_email_field(String invalidEmailAddress) {

		driver.findElement(By.id("email")).sendKeys(invalidEmailAddress);
	}

	@Then("User should see an error message for Invalid email {string}")
	public void user_should_see_an_error_message_for_invalid_email(String string) {

		Assert.assertTrue(driver.findElement(By.xpath("//b[contains(.,'User does not exist')]")).isDisplayed());

	}

	@Then("User should see an error message for Invalid password {string}")
	public void user_should_see_an_error_message_for_invalid_password(String string) {

		Assert.assertTrue(
				driver.findElement(By.xpath("//b[contains(.,'Invalid Login details or Your')]")).isDisplayed());
	}

	@Given("User enters a Invalid password {string} in the password field")
	public void user_enters_a_invalid_password_in_the_password_field(String invalidPassword) {

		driver.findElement(By.id("pass")).sendKeys(invalidPassword);

	}

	@Given("User does not enter an email address in the email field")
	public void user_does_not_enter_an_email_address_in_the_email_field() {

		// Intentionally blank
	}

	@Given("User does not enter a password in the password field")
	public void user_does_not_enter_a_password_in_the_password_field() {

		// Intentionally blank
	}

	@Then("User should see validation error messages")
	public void user_should_see_validation_error_messages() {

		// Intentionally blank
	}

}
