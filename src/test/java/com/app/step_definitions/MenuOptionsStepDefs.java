package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuOptionsStepDefs {

	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();

	@When("^I hover over the (Collaboration|Sales|Marketing|Support|Activities|All) menu$")
	public void i_hover_over_the_Collaboration_menu(String menu) {
		switch (menu) {
		case "Collaboration":
			BrowserUtils.hoverOver(dashboardPage.collaboration);
			break;
		case "Sales":
			BrowserUtils.hoverOver(dashboardPage.sales);
			break;
		case "Marketing":
			BrowserUtils.hoverOver(dashboardPage.marketing);
			break;
		case "Support":
			BrowserUtils.hoverOver(dashboardPage.support);
			break;
		case "Activities":
			BrowserUtils.hoverOver(dashboardPage.activities);
			break;
		case "All":
			BrowserUtils.hoverOver(dashboardPage.all);
			break;
		}
	}

	@Then("^following menu options should be visible for (Collaboration|Sales|Marketing|Support|Activities|All):$")
	public void following_menu_options_should_be_visible_for_Collaboartion(String menu, List<String> options) {
		// for (String string : options) {
		// System.out.println(string);
		// }

		// capture list of webelemets
		List<WebElement> topMenuOptions = dashboardPage.topMenuOptions(menu);
		// get their text in a list
		List<String> topMenuOptionsString = BrowserUtils.getElementsText(topMenuOptions);
		// compare the list with options
		assertEquals(topMenuOptionsString.size(), options.size(), "Number of expected menu options did not match");
		for (int i = 0; i < options.size(); i++) {
			assertEquals(topMenuOptionsString.get(i), options.get(i));
		}

	}
}
