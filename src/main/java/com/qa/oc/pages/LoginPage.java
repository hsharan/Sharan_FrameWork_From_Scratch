package com.qa.oc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.oc.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	//1. Private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPWDLink = By.linkText("Forgotten Password");
	
	
	//2. Public page class Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	//3. Public page actions/methods
	
	public String getLoginPageTitle() {
		
		String loginPageTitle =  eleUtil.waitForTitleIs("Account Login", 5);
		//String loginPageTitle = driver.getTitle();
		System.out.println("Login Page Title : "+loginPageTitle );
		return loginPageTitle;
	}
	public String getLoginPageURL() {
		
		String loginPageUrl =  eleUtil.waitForURLContains("route=account/login", 5);
		//String loginPageUrl = driver.getCurrentUrl();
		System.out.println("Login Page URL : "+loginPageUrl);
		return loginPageUrl;
	}
	public boolean isForgotPwdLinkExist() {
	//return driver.findElement(forgotPWDLink).isDisplayed();
	return eleUtil.isElementDisplayed(forgotPWDLink);
	}
	public String doLogin(String username, String pwd) {
		System.out.println("User Credentials like: "+username + " : " + pwd);
		eleUtil.waitForElementVisible(emailId, 10).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginButton);
		return eleUtil.waitForTitleIs("My Account", 5);
		/*
		 * 
		 * driver.findElement(emailId).sendKeys(username);
		 * driver.findElement(password).sendKeys(pwd);
		 * driver.findElement(loginButton).click(); return driver.getTitle();
		 */
		
	}
}
