Feature: Hands On Assignment in Sept 15.
  @PostTest
  Scenario Outline: I want to login to salesforce
    Given I setup the web driver I want to use
    When I navigate to salesforce login web page
    Then I enter my userName <userName>
    And I enter my Password <password>
    Then I hit the login buttom

    Examples:
      | userName|password|
      |"jiayuez081-ak6j@force.com"|"$Zjy123243"|
