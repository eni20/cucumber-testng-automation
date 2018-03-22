Feature: Contact`s details
  As a user, I should be able to access the contact`s user personal information, 
  so that I have detailed information about that person

@testing
  Scenario: Open contact`s details
    Given I logged into suiteCRM
    When I search for "John Doe"
    And I open contact "John Doe"
    Then contact name should be "John Doe"
    And contact email should be "johnDoe@example.org"
