Feature: Sandbox create user api test
  Scenario: Sending post request to create user through Sandbox api
    Given I have an user object
    When I send post request with user data as body to Sandbox api
    Then I should get a response with status code 201