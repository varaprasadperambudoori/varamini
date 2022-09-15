Feature: Log in SalesForce

  Scenario Outline: Fill out form to log in
    Given I know my "<email>" and "<password>"
    When I enter my information
    And I press the login button
    Then I will see a successful login screen

    Examples:
      |email|password|
      |tester.fengg-wzdw@force.com|123Welcome456|