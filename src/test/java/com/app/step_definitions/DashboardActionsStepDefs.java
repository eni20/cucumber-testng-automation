package com.app.step_definitions;

import com.app.pages.SuiteCRMDashboardPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardActionsStepDefs {
	
	SuiteCRMDashboardPage dashboardPage= new SuiteCRMDashboardPage();
	

	@When("^I post \"([^\"]*)\"$")
	public void i_post(String note) {
		dashboardPage.post(note);
	}

	@Then("^Post should be displayed$")
	public void post_should_be_displayed() {
		
	}
}
