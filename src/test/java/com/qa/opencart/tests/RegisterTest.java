package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.ReadExcelData;

public class RegisterTest extends BaseTest {

	@BeforeClass
	public void regisSetup() {
		regis = login.navigateToRegister();
	}
	
	@DataProvider
	public Object[][] registerData() {
		return ReadExcelData.getTestData("Register");
	}
	
	@Test(dataProvider="registerData")
	public void registerUser(String firstName, String lastName, String email, String telephone, String password,
			String passConfirm) {
		Assert.assertTrue(regis.registerUser(firstName, lastName, email, telephone, password, passConfirm));
	}
}
