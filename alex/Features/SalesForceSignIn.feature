Feature: SalesForce Sign In
  As a user I want access to the next Login page

  Scenario Outline: Sign in On SalesForce
    Given I am on the SalesForce Sign In page
    When I enter my "<email>"
    When I enter my "<password>" and submit
    Then I should access the next page
    Examples:
      |email|password|
      |vuongalexander99-5u6u@force.com|password123|
