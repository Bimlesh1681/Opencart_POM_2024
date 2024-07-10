package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductDetailPageTest extends BaseTest {
	
	@BeforeClass
	public void productDetailPageSetup() {
		acctPage = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@DataProvider
	public Object productImageCountData() {
		return new Object[][] {
			{"macbook","MacBook",5},
			{"macbook","MacBook Air",4},
			{"macbook","MacBook Pro",4},
			
			{"imac","iMac",3},
			
			{"apple","Apple Cinema 30\"",6},
			
			{"samsung","Samsung SyncMaster 941BW",1},
			{"samsung","Samsung Galaxy Tab 10.1",7},
		};
	}
	
	@Test(dataProvider="productImageCountData", priority=1)
	public void getProductImageCountTest(String searchKey, String searchValue, int prodCount) {
		
		searchPage = acctPage.searchProduct(searchKey);
		prodPage = searchPage.selectProduct(searchValue);
		int count = prodPage.getProductImageCount();
		Assert.assertEquals(count, prodCount);
		
	}
	
	@Test(priority=1)
	public void emptyCartTest() {
		acctPage.emptyCart();
	}
	
	@Test(priority=2)
	public void getProductInfoTest() {
		
		searchPage = acctPage.searchProduct("macbook");
		prodPage = searchPage.selectProduct("MacBook");
		Map<String, String> prodMap =  prodPage.getProductInfo();
		System.out.println(prodMap);
		
		Assert.assertEquals(prodMap.get("prodName"), prodPage.getProductNameHeader());
	}
	
	@Test(priority=3)
	public void addProductToCart() {
		searchPage = acctPage.searchProduct("macbook");
		prodPage = searchPage.selectProduct("MacBook");
		prodPage.enterQty(5);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sucMsg = prodPage.addProductToCart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sucMsg);
		Assert.assertEquals(sucMsg, "Success: You have added MacBook to your shopping cart!");
		
	}
}
