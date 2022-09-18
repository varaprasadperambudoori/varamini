Feature: Sandbox Rest Assured API Testing

#USERCASE1
  Scenario Outline: Post to SandboxFundingSources page
    Given I establish the baseURI
    When I input basic authorization credentials
    And I input my body <body> request
    And I input my request header key <key> and value <value>
    Then I post my request
    And I validate the 201 CREATED response code
    Examples:
      |body|key|value|
      |"name"|"Content-Type"|"application/Json"|

