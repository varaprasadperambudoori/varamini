package com.automation.stepdefinitions;

import com.api.apiConstants;
import com.api.object.Header.SandboxHeaders;
import com.api.object.Request.SandboxFundingSourcesRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class sandboxAPICucumberTests {

    SandboxFundingSourcesRequest request = new SandboxFundingSourcesRequest();
    SandboxHeaders sandboxHeader = new SandboxHeaders();
    JSONObject parameters = new JSONObject();

    RequestSpecification httpRequest;
    Response response;

    //USECASE1: SANDBOXFUNDINGSOURCES
    @Given("I establish the baseURI")
    public void i_establish_the_base_uri() {
        RestAssured.baseURI = apiConstants.sandBaseURL;

    }
    @When("I input basic authorization credentials")
    public void i_input_basic_authorization_credentials() {
        httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);


    }
    @When("I input my body {string} request")
    public void i_input_my_body_request(String string) {
        request.setName("Program Mini");
        parameters.put(string, request.getName());

    }
    @When("I input my request header key {string} and value {string}")
    public void i_input_my_request_header_key_and_value(String string, String string2) {
        sandboxHeader.setSandboxHeaderKey(string);
        sandboxHeader.setSandboxHeaderValue(string2);

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());
        httpRequest.body(parameters.toString());
    }
    @Then("I post my request")
    public void i_post_my_request() {
        response = httpRequest.request(Method.POST, apiConstants.sandProgram);        //adds to the body

    }
    @Then("I validate the {int} CREATED response code")
    public void i_validate_the_created_response_code(Integer int1) {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 201);

        System.out.println("Response Status Code Returned is: " + response.getStatusLine());
    }


}