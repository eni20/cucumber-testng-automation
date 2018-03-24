Feature: Merging duplicate contacts
  
  As a user, I should be able to merge duplicate contacts, so that we can prevent future errors.

  @testing1
  Scenario: Merging duplicate contacts
    Given I logged into suiteCRM
    When I search for "John Doe"
    And duplicated contact "John Doe" exists
    When I search for "John Doe"
    When I open contact "John Doe"
    And remove duplicates for this contact
    Then there should be only 1 John Doe in the contacts page
