package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.app.pages.SuiteCRMCreateTaskPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMTaskSummaryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingTasksStepDefs {

	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateTaskPage createTaskPage = new SuiteCRMCreateTaskPage();
	SuiteCRMTaskSummaryPage summaryPage = new SuiteCRMTaskSummaryPage();
	// create MAP
	Map<String, String> createTaskMap = new HashMap<>();
	Map<String, String> overviewTaskMap = new HashMap<>();

	@When("^I click on create task$")
	public void i_click_on_create_task() {
		dashboardPage.clickCreateTask();
	}

	@When("^Set subject as \"([^\"]*)\"$")
	public void set_subject_as(String taskSubject) {
		createTaskPage.subject.sendKeys(taskSubject);
		createTaskMap.put("Subject", taskSubject);
	}

	@When("^Set status as \"([^\"]*)\"$")
	public void set_status_as(String status) {
		Select statusSelect = new Select(createTaskPage.status);
		statusSelect.selectByVisibleText(status);
		createTaskMap.put("Status", status);
	}

	@When("^Start date is todays date$")
	public void start_date_is_todays_date() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String todaysDate = today.format(formatter).toString();

		// LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString();
		createTaskPage.startDate.sendKeys(todaysDate + Keys.TAB);
		createTaskMap.put("Start Date", todaysDate);
	}

	@When("^Due date is (\\d+) days after todays date$")
	public void due_date_is_days_after_todays_date(int daysAhead) {
		String dueDate = LocalDate.now().plusDays(daysAhead).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		createTaskPage.dueDate.sendKeys(dueDate + Keys.TAB);
		createTaskMap.put("Due Date", dueDate);
	}

	@When("^Set \"([^\"]*)\" priority$")
	public void set_priority(String priorityLevel) {
		Select prioritySelect = new Select(createTaskPage.priority);
		prioritySelect.selectByVisibleText(priorityLevel);

		createTaskMap.put("Priority", priorityLevel);
	}

	@When("^Set description as \"([^\"]*)\"$")
	public void set_description_as(String taskDescription) {
		createTaskPage.description.sendKeys(taskDescription);
		createTaskMap.put("Description", taskDescription);
	}

	@When("^Save the task$")
	public void save_the_task() {
		createTaskPage.SAVE.click();
	}

	@Then("^Task details page should be displayed$")
	public void task_details_page_should_be_displayed() {
		assertTrue(summaryPage.taskOverview.isDisplayed());

		overviewTaskMap.put("Subject", summaryPage.subject.getText());
		overviewTaskMap.put("Status", summaryPage.status.getText());
		overviewTaskMap.put("Start Date", summaryPage.date_start.getText().replace(" 12:00am", ""));
		overviewTaskMap.put("Due Date", summaryPage.date_due.getText().replace(" 12:00am", ""));
		overviewTaskMap.put("Priority", summaryPage.priority.getText());
		overviewTaskMap.put("Description", summaryPage.description.getText());

		System.out.println(overviewTaskMap);
		System.out.println(createTaskMap);
	}

	@Then("^Data should match with created task data$")
	public void data_should_match_with_created_task_data() {
		assertEquals(overviewTaskMap, createTaskMap);
	}
}
