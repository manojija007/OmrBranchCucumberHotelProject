package com.omrbranch.hooks;



import org.openqa.selenium.WebDriver;

import com.omrbranch.facotry.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

	WebDriver driver;
	
	@Before
	public void setup() {
		
		driver = DriverFactory.openBrowserAndApplicationURL();
		
	}
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
}
