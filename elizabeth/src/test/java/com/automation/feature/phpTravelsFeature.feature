Feature: Test salesforce login page

#USERCASE1
  Scenario Outline: Launch salesforce login page
    Given I am on salesforce login page
    When I input my username <username> credentials
    And I input my password <password> credentials
    Then I log into my salesforce account
    Examples:
    |username|password|
    |"tester.fengg-wzdw@force.com"|"123Welcome456"|