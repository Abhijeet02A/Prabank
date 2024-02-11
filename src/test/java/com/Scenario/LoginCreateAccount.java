package com.Scenario;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Runner.DataReader;
import com.Runner.MyTestRunner;
public class LoginCreateAccount extends MyTestRunner{
	
	private DataReader dataReader;
	private String userName;
	private String password;
	private Select accountType;
	private Select accountNum;
	
	public LoginCreateAccount() {
		dataReader = new DataReader();
	}
	
	@Test
	public void login() throws InterruptedException {
		launchBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userName = dataReader.readValueForGivenkey("userName");
		password = dataReader.readValueForGivenkey("password");
		driver.findElement(By.name("username")).sendKeys(userName);
		StringBuilder str = new StringBuilder(password);
		str.reverse();
//		System.out.println(str);
		driver.findElement(By.name("password")).sendKeys(str);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@value=\"Log In\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath("//a[text()='Open New Account']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		accountType = new Select(driver.findElement(By.id("type")));
		accountType.selectByVisibleText("SAVINGS");
		accountNum = new Select(driver.findElement(By.id("fromAccountId")));
		accountNum.selectByIndex(0);
		
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='Open New Account']"))).click();
		
		WebElement element = driver.findElement(By.xpath("//p[text()=\"Congratulations, your account is now open.\"]"));
		String text = element.getText();
		System.out.println(text);
		
		try {
			text.contains("Congratulations, your account is now open.");
		} catch (Exception e) {
			System.out.println("Error! Occured");
		}
		
		element = driver.findElement(By.xpath("//*[@id='newAccountId']"));
		String accountNumber = element.getText();
		System.out.println(accountNumber);
		dataReader.writeValueToKey("accountNumber", accountNumber);
		
		closeBroser();
	}
	
	
	
	
	
	
}
