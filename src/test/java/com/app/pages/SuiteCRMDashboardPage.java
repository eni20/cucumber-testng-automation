package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

public class SuiteCRMDashboardPage {
	private WebDriver driver;

	public SuiteCRMDashboardPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "SALES")
	public WebElement sales;

	@FindBy(linkText = "MARKETING")
	public WebElement marketing;

	@FindBy(linkText = "SUPPORT")
	public WebElement support;

	@FindBy(linkText = "ACTIVITIES")
	public WebElement activities;

	@FindBy(linkText = "COLLABORATION")
	public WebElement collaboration;

	@FindBy(linkText = "ALL")
	public WebElement all;

	@FindBy(xpath = "//input[contains(@title,'Post Status')]")
	public WebElement postField;

	@FindBy(xpath = "//div[@class='dashletNonTable']//input[@value='Post']")
	public WebElement postButton;

	@FindBy(id = "with-label")
	public WebElement profileMenu;

	@FindBy(xpath = "(//a[@id='logout_link'])[3]")
	public WebElement logoutlink;

	@FindBy(xpath = "(//input[@id='query_string'])[5]")
	public WebElement searchInput;

	@FindBy(xpath = "(//button[@id='searchbutton'])[3]")
	public WebElement searchButton;

	@FindBy(linkText = "Contacts")
	public WebElement contacts;

	@FindBy(xpath = "//div[.='Create Contact From vCard']")
	public WebElement createContact;

	@FindBy(id = "vcard_file")
	public WebElement chooseFile;

	@FindBy(id = "import_vcard_button")
	public WebElement importVcardButton;

	@FindBy(linkText = "CREATE")
	public WebElement createLink;

	@FindBy(linkText = "Create Task")
	public WebElement createTask;

	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(profileMenu);
		action.perform();
		BrowserUtils.waitForVisibility(logoutlink, 5);
		logoutlink.click();
	}

	public void post(String note) {
		postField.sendKeys(note);
		postButton.click();
	}

	public void addContact() {
		Actions action = new Actions(driver);
		action.moveToElement(all).perform();
		contacts.click();
		createContact.click();
		chooseFile.sendKeys("C:\\Users\\M.METOFF\\Desktop\\Selenium\\john-doe.vcf");
		importVcardButton.click();
	}

	public void clickCreateTask() {
		Actions action = new Actions(driver);
		action.moveToElement(createLink).perform();
		BrowserUtils.waitForVisibility(createTask, 5);
		createTask.click();

	}

}