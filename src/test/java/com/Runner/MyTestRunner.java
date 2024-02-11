package com.Runner;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class MyTestRunner {
	private String url;
	public static WebDriver driver;

	@BeforeTest
	public void beforeSuite() {
		System.out.println("Inside before suite");
		DataReader data = new DataReader();
		url = data.readValueForGivenkey("url");
//	  System.out.println(url);
		System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void launchBrowser() {
		
	}

	public void closeBroser() {
		
	}

	@AfterTest
	public void afterSuite() {
//	  driver.quit();
	}

}
