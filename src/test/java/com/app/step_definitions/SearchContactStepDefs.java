package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.pages.SuiteCRMSearchResultsPage;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchContactStepDefs {

	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMSearchResultsPage searchResultPage = new SuiteCRMSearchResultsPage();

	@Given("^I open contact \"([^\"]*)\"$")
	public void i_open_contact(String arg1) {
		searchResultPage.JohnDoe.click();
	}

	@Then("^contact name should be \"([^\"]*)\"$")
	public void contact_name_should_be(String searchTerm) {
		assertEquals(searchResultPage.contactName(), searchTerm);
	}

	@Then("^contact email should be \"([^\"]*)\"$")
	public void contact_email_should_be(String searchTerm) {
		assertEquals(searchResultPage.emailAddress.getText(), searchTerm);
	}

	@When("^duplicated contact \"([^\"]*)\" exists$")
	public void duplicated_contact_exists(String searchTerm) {
		dashboardPage.addContact();
		// try {
		// assertTrue(searchResultPage.searchResultLinks(searchTerm).size()>1);
		// } catch (AssertionError e) {
		// System.out.println("There is only one "+ searchTerm);
		// }
	}

	@When("^remove duplicates for this contact$")
	public void remove_duplicates_for_this_contact() {
		searchResultPage.JohnDoe.click();
	}

	@Then("^there should be only (\\d+) John Doe in the contacts page$")
	public void there_should_be_only_John_Doe_in_the_contacts_page(int count) {

	}
}
