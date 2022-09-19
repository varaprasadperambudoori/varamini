Feature: Salesforce test
  Scenario: Login to Salesforce
    Given I am on Salesforce login page
    When I enter username and password
    And I press login button
    Then I should login successfully