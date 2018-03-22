package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMTaskSummaryPage extends SuiteCRMCreateTaskPage {

	private WebDriver driver;

	public SuiteCRMTaskSummaryPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

public WebElement date_start;
	
	public WebElement date_due;
	
	@FindBy(linkText="TASK OVERVIEW")
	public WebElement taskOverview;	
	
	@FindBy(xpath= "//div[@field='status']")
	public WebElement status;
	
	@FindBy(xpath= "//div[@field='priority']")
	public WebElement priority;
	
//	@FindBy(xpath= "//div[@field='name']")
//	public WebElement subject;
//	
//	@FindBy(xpath= "//div[@field='description']")
//	public WebElement description;
}
