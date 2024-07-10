package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
	
	private WebDriver driver;

	private By searchResults = By.xpath("//div[@class='product-thumb']");
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public int validateSearchResult() {
		int count = driver.findElements(searchResults).size();
		return count;
	}
	
	
	public ProductDetailPage selectProduct(String prodName) {
		if(validateSearchResult()>0) {
			driver.findElement(By.linkText(prodName)).click();
		}else {
			System.out.println("there are no products to select");
		}
		return new ProductDetailPage(driver);
	}
	
}
