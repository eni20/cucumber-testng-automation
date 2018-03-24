package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMSearchResultsPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateContactsStepDefs {

	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateContactPage createContactPage = new SuiteCRMCreateContactPage();
	SuiteCRMSearchResultsPage searchResultPage = new SuiteCRMSearchResultsPage();

	@Given("^I open the create contact page$")
	public void i_open_the_create_contact_page() {
		BrowserUtils.hoverOver(dashboardPage.createLink);
		dashboardPage.createContact.click();
	}

	@Given("^I enter the first name \"([^\"]*)\" and the last name \"([^\"]*)\"$")
	public void i_enter_the_first_name_and_the_last_name(String firstName, String lastName) {
		createContactPage.first_name.sendKeys(firstName);
		createContactPage.last_name.sendKeys(lastName);
	}

	@Given("^I enter the phone number \"([^\"]*)\"$")
	public void i_enter_the_phone_number(String phoneNumber) {
		createContactPage.phone_work.sendKeys(phoneNumber);
	}

	@Given("^I enter the department \"([^\"]*)\"$")
	public void i_enter_the_department(String department) {
		createContactPage.department.sendKeys(department);
	}

	@When("^click on the save button$")
	public void click_on_the_save_button() {
		createContactPage.SAVE.click();
		try {
			Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			createContactPage.saveButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^I should see contact information for \"([^\"]*)\"$")
	public void i_should_see_contact_information_for(String contactInfo) {

		assertEquals(searchResultPage.contactName(), contactInfo);
		assertEquals(createContactPage.first_name.getText(), contactInfo.split(" ")[0]);
		 assertEquals(createContactPage.last_name.getText(), contactInfo.split(" ")[1]);
	}
}
