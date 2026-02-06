package com.omrbranch.stepdefinition;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.omrbranch.facotry.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchHotelStep {

	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait;

	@When("User searches hotels using below fields")
	public void user_searches_hotels_using_below_fields(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		driver = DriverFactory.getDriver();

		// Convert DataTable into Map (Field → Value)
		Map<String, String> map = dataTable.asMap(String.class, String.class);

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Get values from table
		String state = map.get("State");
		String city = map.get("City");
		String roomType = map.get("Room type");
		String checkInDate = map.get("Check in date");
		String checkOutDate = map.get("Check out date");
		String noOfRooms = map.get("No of Rooms");
		String noOfAdults = map.get("No of Adults");
		String noOfChildren = map.get("No of Children");

		// Select Sate

		WebElement stateDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("state")));
		Select selectState = new Select(stateDropDown);
		selectState.selectByVisibleText(state);

		// Select City not real dropdown so use implicitwait

		WebElement cityDropDown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select City *']")));
		cityDropDown.click();

		// If Dropdown has Search Box -
		WebElement searchCityBox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));
		searchCityBox.sendKeys(city);
		searchCityBox.sendKeys(Keys.ENTER);

		// Select Rooms - Step 1: Dropdown click
		WebElement selectRoomType = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-search__field']")));
		selectRoomType.click();

		// Step 2: Option click (Example: Deluxe)
		WebElement roomOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-search__field']")));
		roomOption.sendKeys(roomType);
		roomOption.sendKeys(Keys.ENTER);

		// Select check in date
		WebElement checkIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='check_in']")));
		checkIn.click();

		String day = checkInDate.split("-")[2];

		WebElement chkInDate = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + day + "']")));
		chkInDate.click();

		WebElement checkOut = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='check_out']")));
		checkOut.click();

		String checkOutDay = checkOutDate.split("-")[2];

		WebElement chkOutDate = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + checkOutDay + "']")));
		chkOutDate.click();

		WebElement NoOfRooms = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='no_rooms']")));
		Select selectNoOfRooms = new Select(NoOfRooms);
		selectNoOfRooms.selectByVisibleText(noOfRooms);

		WebElement NoOfAdults = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='no_adults']")));
		Select selectNoOfAdults = new Select(NoOfAdults);
		selectNoOfAdults.selectByVisibleText(noOfAdults);

		WebElement noOfChildren1 = driver.findElement(By.id("no_child"));
		noOfChildren1.sendKeys(noOfChildren);

	}

	@When("User click search button")
	public void user_click_search_button() {

		// Click Search Button inside frame

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='hotelsearch_iframe']"));// switch to frame
																										// using frame
																										// element
		driver.switchTo().frame(frameElement);
		WebElement searchButton = driver.findElement(By.id("searchBtn"));
		searchButton.click();
		driver.switchTo().defaultContent();

	}

	@Then("User should verify showing all hotel list {string}")
	public void user_should_verify_showing_all_hotel_list(String expMessage) throws InterruptedException {
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		String actMessage = driver.findElement(By.xpath("//a[text()='Clear']")).getText();
//		System.out.println(actMessage);
//		Assert.assertEquals(expMessage, actMessage);
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Select Hotel']")));
		String actMessage = heading.getText();
		System.out.println(actMessage);
		Assert.assertEquals(expMessage, actMessage);
	}

	@Then("User click the Book Hotel option")
	public void User_click_the_Book_Hotel_option() {

		driver.findElement(By.xpath("//a[text()='Book Hotel']")).click();
	}
}
