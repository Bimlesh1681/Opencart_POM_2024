package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.appconstant.Opencart_AppConstant;

public class Register {

	private WebDriver driver;

	public Register(WebDriver driver) {
		this.driver = driver;
	}

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By passConfirm = By.id("input-confirm");
	private By subYes = By.xpath("//input[@name='newsletter' and @value='1']");
	private By subNo = By.xpath("//input[@name='newsletter' and @value='0']");
	private By agreeCheck = By.xpath("//input[@type='checkbox' and @value='1']");
	private By conBtn = By.xpath("//input[@type='submit']");
	private By acctCreation = By.xpath("//div[@id='content']/h1");
	private By logout = By.linkText("Logout");
	private By register = By.linkText("Register");

	public boolean registerUser(String firstName, String lastName, String email, String telephone, String password,
			String passConfirm) {

		driver.findElement(this.firstName).clear();
		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.lastName).clear();
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.email).clear();
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.telephone).clear();
		driver.findElement(this.telephone).sendKeys(telephone);
		driver.findElement(this.password).clear();
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.passConfirm).clear();
		driver.findElement(this.passConfirm).sendKeys(passConfirm);
		
		if(driver.findElement(subYes).isSelected()) {
			driver.findElement(subYes).click();
		}else {
			driver.findElement(subNo).click();
		}
		
		driver.findElement(agreeCheck).click();
		driver.findElement(conBtn).click();
		
		String sucMsg = driver.findElement(acctCreation).getText();
		
		if(sucMsg.contains(Opencart_AppConstant.REGISTER_SUCCESSFUL_MESSG)) {
			driver.findElement(logout).click();
			driver.findElement(register).click();
			return true;
		}
		return false;
	}
}
