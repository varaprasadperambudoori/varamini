Feature: Saleforce Login Testing
  Scenario: I am logging in to Saleforce using my credentials
    Given I am in Salefoce log in page
    When I enter username
      And I enter password
      And I press enter key
    Then I should see the portal page
