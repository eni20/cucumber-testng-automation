Feature: SuiteCRM menu options

  @table
  Scenario: Verify Collaboration menu options
    Given I logged into suiteCRM
    When I hover over the Collaboration menu
    Then following menu options should be visible for Collaboration:
      | Home      |
      | Emails    |
      | Documents |
      | Projects  |

  @table
  Scenario: Verify Support menu options
    Given I logged into suiteCRM
    When I hover over the Support menu
    Then following menu options should be visible for Support:
      | Home     |
      | Accounts |
      | Contacts |
      | Cases    |
