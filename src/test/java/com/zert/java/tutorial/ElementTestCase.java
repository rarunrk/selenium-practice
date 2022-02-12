package com.zert.java.tutorial;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementTestCase {

	public String baseUrl = "https://demoqa.com/";
	public WebDriver driver;

	@BeforeTest
	public void SetBaseUrl() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	@Test
	public void TestElements() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	    WebDriverWait  webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    By by = By.xpath("//h5[contains(text(),'Elements')]");
	    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
		WebElement webElement = driver.findElement(by); 
		webElement.click(); 
		webElement = driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")); 
		webElement.click(); 
		
		driver.findElement(By.id("userName")).sendKeys("Test"); 	
		driver.findElement(By.id("userEmail")).sendKeys("test@test.com"); 	
		driver.findElement(By.id("currentAddress")).sendKeys("SDADFFASDFAF"); 
		driver.findElement(By.id("permanentAddress")).sendKeys("cvcxxbcffhvbx"); 
		js.executeScript("window.scrollBy(0,500)", "");
		webElement= driver.findElement(By.xpath("//button[@id='submit']") );
		webElement.click(); 
		String name =   driver.findElement(By.id("name")).getText();
		System.out.println("Name is "+ name);
		boolean isNameExists = name.contains("Test");
	    String email = driver.findElement(By.id("email")).getText(); 
	    System.out.println("email is"+ email);
	    Assert.assertEquals(email, "Email:test@test.com"); 
	    // Thread.sleep(10000);
	    String currentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText(); 
	    System.out.println("currentAddress is"+ currentAddress);
	    Assert.assertEquals(currentAddress, "Current Address :SDADFFASDFAF"); 
	    String permanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText(); 
	    System.out.println("permanentAddress is"+ permanentAddress);
	    Assert.assertEquals(permanentAddress, "Permananet Address :cvcxxbcffhvbx"); 
			
		
	//	Assert.assertEquals(name, "Name:Test");
		Assert.assertTrue(isNameExists);
		
	 				
	}
	
	@Test
	public void checkBox_click_commands() throws InterruptedException {
		driver.navigate().to(baseUrl); // Other way to navigate to url
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	    WebDriverWait  webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    webDriverWait.ignoring(NoSuchElementException.class);
	    
	    By by = By.xpath("//h5[contains(text(),'Elements')]");
	    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
		WebElement webElement = driver.findElement(by); 
		webElement.click(); 
		
		Thread.sleep(2000);
		by = By.xpath("//span[contains(text(),'Check Box')]");
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));  
		 webElement =  driver.findElement(by); 
		webElement.click();  
		
		by = By.xpath("//button[@class='rct-collapse rct-collapse-btn']"); 
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));  
		 webElement = driver.findElement(by);
		  webElement.click(); 
		
		webElement = driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[2]")); 
		webElement.click(); 
		
		by = By.xpath("//label[@for='tree-node-commands']/span[1]/*[1]"); 
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));  
		webElement = driver.findElement(by); 
		
		
		js.executeScript("arguments[0].setAttribute('class', 'rct-icon rct-icon-check')", webElement);
		
		System.out.println(webElement.isEnabled());
		System.out.println(webElement.isDisplayed());
		
		webElement.click();
		
		webElement = driver.findElement(by); 
		
		String classValue = webElement.getAttribute("class"); 
        boolean isChecked  =   classValue.contains("rct-icon rct-icon-check"); 
        Assert.assertTrue(isChecked); 
		
			
	}
	
	@Test
	public void checkBox_click_office() throws InterruptedException {
		
		driver.navigate().to(baseUrl); // Other way to navigate to url
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	    WebDriverWait  webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    webDriverWait.ignoring(NoSuchElementException.class);
	    
	    By by = By.xpath("//h5[contains(text(),'Elements')]");
	    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
		WebElement webElement = driver.findElement(by); 
		webElement.click(); 
		
		Thread.sleep(2000);
		by = By.xpath("//span[contains(text(),'Check Box')]");
		webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, "Check Box"));  
		webElement =  driver.findElement(by); 
		webElement.click();  
		
		
		//Thread.sleep(5000);
		
		by = By.xpath("//button[@class='rct-collapse rct-collapse-btn']"); 
		// webDriverWait.until(ExpectedConditions.attributeToBe(by, "class", "rct-collapse rct-collapse-btn"));  
		webElement = driver.findElement(by);
		webElement.click(); 
		  
		by = By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[3]"); 
		 webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
		webElement	= driver.findElement(by); 
		webElement.click(); 
		

		  by= By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[5]/*[1]"); 
		  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
		  webElement =  driver.findElement(by); 
		  
		  
		  js.executeScript("arguments[0].setAttribute('class', 'rct-icon rct-icon-expand-open')", webElement);
		 
		  
		    webElement.click();  
		    
		    by=By.xpath("//label[@for='tree-node-office']/span[1]/*[1]"); 
		    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		    webElement = driver.findElement(by); 
		    
			js.executeScript("arguments[0].setAttribute('class', 'rct-icon rct-icon-check')", webElement);
			
			webElement.click();
			
			//label[@for='tree-node-general']/span[1]/*[1]
			
			
		   webElement = driver.findElement(By.xpath("//label[@for='tree-node-general']/span[1]/*[1]")); 
		   String classValue = webElement.getAttribute("class");
		   System.out.println(classValue);
		   boolean isCheckboxChecked = classValue.contains("check");
		   Assert.assertTrue(isCheckboxChecked);
	   
 
	      

	 }
	
	/*@AfterTest
	public void cleanUp() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}*/
	
}
