package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AppLogin;
import com.qa.opencart.pages.MyAccounts;
import com.qa.opencart.pages.ProductDetailPage;
import com.qa.opencart.pages.Register;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected AppLogin login;
	protected MyAccounts acctPage;
	protected SearchResultsPage searchPage;
	protected ProductDetailPage prodPage;
	protected Register regis;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		login = new AppLogin(driver);
	}

	@AfterTest
	public void tearDown() {

	}

}
