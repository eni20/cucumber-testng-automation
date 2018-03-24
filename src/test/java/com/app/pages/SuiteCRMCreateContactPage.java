package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateContactPage {

	private WebDriver driver;

	public SuiteCRMCreateContactPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	public WebElement first_name;
	
	public WebElement last_name;
	
	public WebElement phone_work;
	
	public WebElement department;
	
	public WebElement SAVE;
	
	@FindBy(xpath="//input[@title='Save']")
	public WebElement saveButton;
}
