package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppLogin {

	private WebDriver driver;

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotPasswordLink = By.xpath("//div[@class='form-group']/a");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By myAccount = By.xpath("//span[text()='My Account']");
	private By logout = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a[text()='Logout']");
	private By register = By.linkText("Register");

	public AppLogin(WebDriver driver) {
		this.driver = driver;
	}

	public String loginPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the appLogin page is :"+title);
		
		return title;
	}

	public String loginPageUrl() {

		return driver.getCurrentUrl();
	}

	public boolean isforgotPasswordLinkPresent() {
		boolean status = driver.findElement(forgotPasswordLink).isDisplayed();
		return status;
	}

	public MyAccounts doLogin(String username, String pass) {
		
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
		return new MyAccounts(driver);
	}

	public void appLogout() {

		driver.findElement(myAccount).click();
		driver.findElement(logout).click();
	}

	public Register navigateToRegister() {
		driver.findElement(register).click();
		return new Register(driver);
	}
}
