Feature: Rest Assured Api Framework Testing
  Users should be able to submit GET and POST requests to a web service,
  Scenario: GET all users
    Given I set the baseURI
    When I set the get all users endpoint
      And I set username and password for basic auth
      And I send the GET method
    Then I should receive status code 200