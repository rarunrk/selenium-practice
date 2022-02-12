package com.zert.java.tutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest{
	
	public  String baseUrl= "https://www.amazon.in/"; 
	public  WebDriver driver; 

	@BeforeTest
	public void setBaseurl() {
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver(); 
	    driver.get(baseUrl);
	}
	
	@Test
	public void VerifyHomePageTitle() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"; 
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@AfterTest
		public void endSession() {
		driver.quit();
	}
	 }
