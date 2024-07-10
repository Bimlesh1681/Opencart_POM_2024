package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {

	private WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	private By productImages = By.xpath("//div[@id='content']//ul[@class='thumbnails']/li");
	private By productNameHeader = By.xpath("//div[@id='content']//h1");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	private By qty = By.id("input-quantity");
	private By addToCart = By.id("button-cart");
	private Map<String, String> prodMap = new HashMap<String, String>();
	private By succMsg = By.cssSelector("div.alert-dismissible");
	
	

	public String getProductNameHeader() {
		String name = driver.findElement(productNameHeader).getText();
		return name;
	}

	public int getProductImageCount() {
		return driver.findElements(productImages).size();
	}

	public Map<String, String> getProductInfo() {
		prodMap.put("prodName", getProductNameHeader());
		getProductDetailInfo();
		getProductPriceInfo();
		
		return prodMap;
	}

	private void getProductDetailInfo() {
		List<WebElement> prodData = driver.findElements(productMetaData);
		for (WebElement we : prodData) {
			String prodtext = we.getText();

			String prodDataSplit[] = prodtext.split(":");

			String prodKey = prodDataSplit[0].trim();
			String prodValue = prodDataSplit[1].trim();

			prodMap.put(prodKey, prodValue);
		}

	}

	private void getProductPriceInfo() {
		List<WebElement> priceData = driver.findElements(productPriceData);
		String price = priceData.get(0).getText().trim();
		prodMap.put("price", price);

		String tax = priceData.get(1).getText();
		String exTax = tax.split(":")[1];
		prodMap.put("exTax", exTax);
	}

	

	
	public void enterQty(int qty) {
		driver.findElement(this.qty).clear();
		driver.findElement(this.qty).sendKeys(String.valueOf(qty));
	}
	
	
	public String addProductToCart() {
		driver.findElement(addToCart).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = driver.findElement(succMsg).getText();
		msg = msg.substring(0,msg.length()-1).replace("\n", "");
		return msg;	
		
	}
}
