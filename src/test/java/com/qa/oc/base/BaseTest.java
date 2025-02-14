package com.qa.oc.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.oc.factory.DriverFactory;
import com.qa.oc.pages.LoginPage;

public class BaseTest {
	WebDriver driver;
	Properties prop;
	DriverFactory df;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
	df = new DriverFactory();
	prop = df.initProp();
	driver = df.initDriver(prop);
	loginPage = new LoginPage(driver);
	
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
