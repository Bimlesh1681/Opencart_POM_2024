package com.qa.opencart.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.appconstant.Opencart_AppConstant;
import com.qa.opencart.base.BaseTest;

public class MyAccountsTest extends BaseTest {

	@BeforeClass
	public void acctPageSetup() {
		acctPage = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void getAcctPageTitleTest() {
		String title = acctPage.getAcctPageTitle();
		Assert.assertEquals(title, Opencart_AppConstant.ACCOUNT_PAGE_TILE);
	}

	@Test(priority = 2)
	public void getAcctPageURLTest() {
		String url = acctPage.getAcctPageURL();
		Assert.assertTrue(url.contains(Opencart_AppConstant.ACCOUNT_PAGE_URL));
	}

	@Test(priority = 3)
	public void getAcctPageHeadersCountTest() {
		int count = acctPage.getAcctPageHeadersCount();
		Assert.assertEquals(count, Opencart_AppConstant.ACCT_PAGE_HEADERS_COUNT);
	}

	@Test(priority = 4)
	public void getAcctPageHeadersDetailTest() {
		ArrayList<String> headersList = acctPage.getAcctPageHeadersDetail();
		Assert.assertEquals(headersList, Opencart_AppConstant.accountsPageHeaders());
	}

	@DataProvider()
	public Object productSearchData() {
		return new Object[][] { { "macbook" }, { "imac" }, { "apple" }, { "samsung" }

		};
	}

	@Test(dataProvider = "productSearchData", priority = 5)
	public void searchProductTest(String prodName) {
		searchPage = acctPage.searchProduct(prodName);
		Assert.assertTrue(searchPage.validateSearchResult() > 0);
	}

	@DataProvider()
	public Object selectProductData() {
		return new Object[][] { { "macbook", "MacBook" }, { "macbook", "MacBook Air" }, { "macbook", "MacBook Pro" },

				{ "imac", "iMac" },

				{ "apple", "Apple Cinema 30\"" },

				{ "samsung", "Samsung SyncMaster 941BW" }, { "samsung", "Samsung Galaxy Tab 10.1" }

		};
	}

	@Test(dataProvider = "selectProductData", priority = 6)
	public void selectProductTest(String searchKey, String searchValue) {
		searchPage = acctPage.searchProduct(searchKey);
		searchPage.selectProduct(searchValue);

	}

}
