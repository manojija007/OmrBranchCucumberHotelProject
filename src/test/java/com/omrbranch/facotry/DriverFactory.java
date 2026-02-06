package com.omrbranch.facotry;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class DriverFactory {

	static WebDriver driver;
	
	public static WebDriver openBrowserAndApplicationURL() {	
	
		
		
		String browser = "chrome";
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equals("safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.omrbranch.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		return driver;
			
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}
	
