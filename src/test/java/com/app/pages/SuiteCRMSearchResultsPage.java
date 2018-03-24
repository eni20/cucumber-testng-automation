package com.app.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMSearchResultsPage {
	private WebDriver driver;

	public SuiteCRMSearchResultsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public WebElement resultLink(String string) {
		return driver.findElement(By.linkText(string));
	}
	
	public List<WebElement> resultLinks(String string){
		return driver.findElements(By.linkText(string));
	}
	
	@FindBy(linkText="John Doe")
	public WebElement JohnDoe;
	
	@FindBy(id="first_name")
	public WebElement firstName;
	
	@FindBy(id="last_name")
	public WebElement lastName;
	
	@FindBy(linkText="johnDoe@example.org")
	public WebElement emailAddress;
	
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[4]")
	public WebElement actions;
	
	@FindBy(id="merge_duplicate_button")
	public WebElement findDuplicates;
	
	public WebElement next_step_button;
	
	@FindBy(css ="input[title='Select this row']")
	public WebElement selectBox;
	
	public WebElement perform_merge_button;
	
	public WebElement save_merged_record_button;
	
	public String contactName() {
		return firstName.getText()+" "+lastName.getText();
	}
	public List<WebElement> searchResultLinks(String string){
		return driver.findElements(By.linkText(string));
	}
}
