package com.qa.oc.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.oc.base.BaseTest;

public class LoginPageTest extends BaseTest{

	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle,"Account Login");
	}
	
	@Test(priority = 2)
	public void loginPageUrlTest() {
		String actualUrl = loginPage.getLoginPageURL();
		Assert.assertTrue(actualUrl.contains("route=account/login"));
	}
	
	@Test(priority = 3)
	public void forgotPwdExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(priority = 4)
	public void loginTest() {
		String accPageTitle = loginPage.doLogin("sshagargi@gmail.com ", "!30March");
				Assert.assertEquals(accPageTitle,"My Account");
		
		
	}
	
}
