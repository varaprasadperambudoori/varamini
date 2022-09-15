package com.api.framework.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class getMethodTestingStepDefinition {
    static RequestSpecification request;
    static Response response;
    static String base_uri;
    static String get_all_users_endpoint = "/users";

    @Given("I set the baseURI")
    public void i_set_the_base_uri() {
        // Write code here that turns the phrase above into concrete actions
        base_uri = "https://sandbox-api.marqeta.com/v3";
    }
    @When("I set the get all users endpoint")
    public void i_set_the_get_all_users_endpoint() {
        base_uri = base_uri + get_all_users_endpoint;
        RestAssured.baseURI = base_uri;

    }
    @When("I set username and password for basic auth")
    public void i_set_username_and_password_for_basic_auth() {
        // Write code here that turns the phrase above into concrete actions
        request = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");
    }

    @When("I send the GET method")
    public void i_send_the_get_method() {
        response = request.get();
    }

    @Then("I should receive status code {int}")
    public void i_should_receive_status_code(Integer int1) {
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
    }
}
