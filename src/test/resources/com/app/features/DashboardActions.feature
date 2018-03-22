Feature: Note on Dashboard

Scenario: Post a note on Dashboard
Given I logged into suiteCRM
When I post "Happy Sunday"
Then Post should be displayed

