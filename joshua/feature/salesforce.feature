Feature: Sign into salesforce account

    @tags
    Scenario: :Check to see if login page opens with chrome drivers

        Given I am on salesforce sign in page
        When I input the sign in information
        Then I sign into the salesforce account