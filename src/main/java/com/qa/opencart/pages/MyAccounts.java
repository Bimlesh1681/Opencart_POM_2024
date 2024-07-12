package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccounts {

	private WebDriver driver;
	private By searchBox = By.name("search");
	private By searchBtn = By.xpath("//span[@class='input-group-btn']/button[@type='button']");
	private By acctPageHeaders = By.xpath("//div[@id='content']/h2");
	private By shoppingCart = By.xpath("//span[text()='Shopping Cart']");
	private By removeItemBtn = By.xpath("//button[@data-original-title='Remove']");

	public MyAccounts(WebDriver driver) {
		this.driver = driver;
	}

	public String getAcctPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the page is "+title);
		return title;
	}

	public String getAcctPageURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public int getAcctPageHeadersCount() {
		int size = driver.findElements(acctPageHeaders).size();
		return size;
	}

	public ArrayList<String> getAcctPageHeadersDetail() {
		ArrayList<String> al = new ArrayList<String>();

		List<WebElement> headerList = driver.findElements(acctPageHeaders);

		for (WebElement e : headerList) {
			String headerText = e.getText();
			al.add(headerText);
		}
		return al;
	}
	
	
	public SearchResultsPage searchProduct(String prodName) {
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(prodName);
		driver.findElement(searchBtn).click();
		return new SearchResultsPage(driver);
	}
	
	public void emptyCart() {
		driver.findElement(shoppingCart).click();
		while(driver.findElement(removeItemBtn).isDisplayed()) {
			driver.findElement(removeItemBtn).click();
			break;
		}
	}
}
