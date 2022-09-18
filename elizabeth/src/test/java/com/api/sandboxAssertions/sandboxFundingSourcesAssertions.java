package com.api.sandboxAssertions;

import com.api.apiConstants;
import com.api.object.Header.SandboxHeaders;
import com.api.object.Request.SandboxFundingSourcesRequest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.Map;

import static io.restassured.RestAssured.get;

public class sandboxFundingSourcesAssertions {
    SandboxFundingSourcesRequest request = new SandboxFundingSourcesRequest();
    SandboxHeaders sandboxHeader = new SandboxHeaders();
    JSONObject parameters = new JSONObject();


    @Test
    public void sandboxSourcesAssertStatusCode() throws JSONException {
        request.setName("Program Mini");

        RestAssured.baseURI = apiConstants.sandBaseURL;

        RequestSpecification httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);

        parameters.put("name", request.getName());

        sandboxHeader.setSandboxHeaderKey("Content-Type");
        sandboxHeader.setSandboxHeaderValue("application/json");

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());
        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandProgram);        //adds to the body

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 201);

        System.out.println("Response Status Code Returned is: " + response.getStatusLine());
    }

    @Test
    public void sandboxSourcesAssertHeaderValidate() throws JSONException {
        request.setName("Program Mini");

        RestAssured.baseURI = apiConstants.sandBaseURL;

        RequestSpecification httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);

        parameters.put("name", request.getName());

        sandboxHeader.setSandboxHeaderKey("Content-Type");
        sandboxHeader.setSandboxHeaderValue("application/json");

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandProgram);        //adds to the body

        String headerValue = String.valueOf(response.getContentType());
        System.out.println(headerValue);
        Assert.assertTrue(String.valueOf(headerValue.contains("application/json")), true);
    }

    @Test
    public void sandboxSourcesFalseValidateBodyContent() throws JSONException {
        request.setName("Program Mini");

        RestAssured.baseURI = apiConstants.sandBaseURL;

        RequestSpecification httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);

        parameters.put("name", request.getName());

        sandboxHeader.setSandboxHeaderKey("Content-Type");
        sandboxHeader.setSandboxHeaderValue("application/json");

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandProgram);        //adds to the body

        String responseBody = response.getBody().prettyPrint();

        Assert.assertFalse(String.valueOf(responseBody.contains("Program Mini")), false);

    }

    @Test
    public void sandboxSourcesValidateBodyContentTrue() throws JSONException {
        request.setName("Program Mini");

        RestAssured.baseURI = apiConstants.sandBaseURL;

        RequestSpecification httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);

        parameters.put("name", request.getName());

        sandboxHeader.setSandboxHeaderKey("Content-Type");
        sandboxHeader.setSandboxHeaderValue("application/json");

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandProgram);        //adds to the body

        String responseBody = response.getBody().prettyPrint();

        Assert.assertTrue(String.valueOf(responseBody.contains("Program Mini")), true);

    }
}
