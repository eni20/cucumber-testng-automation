Feature: Creating contacts

  @create_contact
  Scenario: Create contact using CREATE page
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "Ronald" and the last name "Finger"
    And I enter the phone number "202-000-0000"
    And I enter the department "IT"
    When click on the save button
    Then I should see contact information for "Ronald Finger"

  @create_contact
  Scenario: Create contact using CREATE page
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "Sarah" and the last name "Connor"
    And I enter the phone number "202-000-0000"
    And I enter the department "IT"
    When click on the save button
    Then I should see contact information for "Sarah Connor"

@create_contact
    Scenario Outline: Create Create multiple contacts
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "Sarah" and the last name "Connor"
    And I enter the phone number "202-000-0000"
    And I enter the department "IT"
    #When click on the save button
    #Then I should see contact information for "Sarah Connor"
    
    Examples: 
    ||