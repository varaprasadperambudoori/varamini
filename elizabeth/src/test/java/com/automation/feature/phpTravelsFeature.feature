Feature: Test salesforce login page

#USERCASE1
  Scenario: Launch salesforce login page
    Given I am on salesforce login page
    When I input my credentials
    Then I log into my salesforce account