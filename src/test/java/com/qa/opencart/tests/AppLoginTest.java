package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.appconstant.Opencart_AppConstant;
import com.qa.opencart.base.BaseTest;

public class AppLoginTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = login.loginPageTitle();
		Assert.assertEquals(title, Opencart_AppConstant.LOGIN_PAGE_TILE);
	}

	@Test(priority = 2)
	public void loginPageUrlTest() {
		String url = login.loginPageUrl();
		Assert.assertTrue(url.contains(Opencart_AppConstant.LOGIN_PAGE_URL));
	}

	@Test(priority = 3)
	public void isforgotPasswordLinkPresentTest() {
		Assert.assertTrue(login.isforgotPasswordLinkPresent());
	}

	@Test(priority = 4)
	public void doLoginTest() {
		login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=5)
	public void appLogoutTest() {
		login.appLogout();
	}
	
	
}
