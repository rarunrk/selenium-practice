package com.zert.java.tutorial;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadTest {
	
	public String baseUrl ="https://github.com/settings/profile";
	public WebDriver driver;

	@BeforeTest
	public void SetBaseUrl() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}
	
	

	@Test
	public void fileUpload_Test() throws InterruptedException, AWTException {
		Thread.sleep(2000);// Xpath for Edit button
		driver.findElement(By.id("login_field")).sendKeys("rarunrk");
		driver.findElement(By.id("password")).sendKeys("Ananya2011$");
		
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		

		WebElement file = driver.findElement(By.xpath("//img[@class='avatar rounded-2 avatar-user']"));
				file.click(); //link text locator for uploading a photo..
		WebElement addFile = driver.findElement(By.xpath("//label[@for='avatar_upload']"));
		addFile.click();
		// Mention the own path of the file location

		// Add file method 
		//addFile.sendKeys("C:\\Users\\rarun\\OneDrive\\Desktop\\dragon.png");// For setting a profile picture

		Thread.sleep(2000); // suspending execution for specified time period
		 
	    // creating object of Robot class
	    Robot rb = new Robot();
	 
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("C:\\Users\\rarun\\OneDrive\\Desktop\\love.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    
	    WebDriverWait  webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    By by = By.xpath("//button[@value='save']");
	    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
	    WebElement saveButtonElement = driver.findElement(by);
	    
	    saveButtonElement.click();
		/*
		 * if(driver.findElement(By.xpath(".//a[text()='caps.jpeg']")).isDisplayed()) {
		 * Assert.assertTrue(true, "Profile picture is Uploaded"); }else {
		 * Assert.assertTrue(false, "Profile picture not Uploaded"); }
		 */
	}

}
