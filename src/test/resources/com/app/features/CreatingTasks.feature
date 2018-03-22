Feature: Creating tasks

@Dev
  Scenario: Create a task
    Given I logged into suiteCRM
    When I click on create task
    And Set subject as "Study interview questions"
    And Set status as "In Progress"
    And Start date is todays date
    And Due date is 5 days after todays date
    And Set "Medium" priority
    And Set description as "Go over all 63 interview questions in PowerPoint"
    And Save the task
    Then Task details page should be displayed
    And Data should match with created task data
		Then I logout from application 