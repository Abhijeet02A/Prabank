package com.Scenario;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Runner.DataReader;
import com.Runner.MyTestRunner;

public class Register extends MyTestRunner{
	
	private String dataHolder;
	private DataReader dataReader;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement register_Url;
	
	public Register() {
		dataReader = new DataReader();
	}
	
	
	
	
	@Test
	public void register() {
		launchBrowser();
		System.out.println("I am here to register");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		register_Url.click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dataHolder = dataReader.readValueForGivenkey("firstName");
		driver.findElement(By.name("customer.firstName")).sendKeys(dataHolder);
		dataHolder = dataReader.readValueForGivenkey("lastName");
		driver.findElement(By.name("customer.lastName")).sendKeys(dataHolder);
		dataHolder = dataReader.readValueForGivenkey("address");
		driver.findElement(By.name("customer.address.street")).sendKeys(dataHolder);
		dataHolder = dataReader.readValueForGivenkey("city");
		driver.findElement(By.name("customer.address.city")).sendKeys(dataHolder);
		dataHolder = dataReader.readValueForGivenkey("state");
		driver.findElement(By.name("customer.address.state")).sendKeys(dataHolder);
		dataHolder = dataReader.readValueForGivenkey("zipCode");
		driver.findElement(By.name("customer.address.zipCode")).sendKeys(dataHolder);
		dataHolder = dataReader.readValueForGivenkey("phone");
		driver.findElement(By.name("customer.phoneNumber")).sendKeys(dataHolder);
		dataHolder = dataReader.readValueForGivenkey("ssn");
		driver.findElement(By.name("customer.ssn")).sendKeys(dataHolder);
		
		
		dataHolder = dataReader.readValueForGivenkey("userName");
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    System.out.println(generatedString);
		
		driver.findElement(By.name("customer.username")).sendKeys(generatedString);
		dataReader.writeValueToKey("userName", generatedString);
		dataHolder = dataReader.readValueForGivenkey("password");
		StringBuilder str = new StringBuilder(dataHolder);
		str.reverse();
		driver.findElement(By.name("customer.password")).sendKeys(str);
		dataHolder = dataReader.readValueForGivenkey("password");
		str = new StringBuilder(dataHolder);
		str.reverse();
		driver.findElement(By.name("repeatedPassword")).sendKeys(str);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='Register']"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		closeBroser();
	}
}
