package com.api.sandboxAssertions;

import com.api.apiConstants;
import com.api.object.Header.SandboxHeaders;
import com.api.object.Request.SandboxFundingSourcesRequest;
import com.api.object.Request.SandboxUsersRequest;
import com.api.object.Response.SandboxUsersResponse;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class sandboxUsersAssertions {

    SandboxUsersRequest request = new SandboxUsersRequest();
    JSONObject parameters = new JSONObject();
    SandboxHeaders sandboxHeader = new SandboxHeaders();
    SandboxUsersResponse jsonResponse = new SandboxUsersResponse();

    @Test
    public void sandboxUsersAssertStatusCode() throws JSONException {

        RestAssured.baseURI = apiConstants.sandBaseURL;

        RequestSpecification httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);

        request.setFirstName("Elizabeth");
        request.setLastName("Feng");
        request.setActive(true);
        request.setEmail("elizabethfengabcdefghijklmnopqrstuvwxyz@gmail.com");  //need to change email to run
        request.setPhone("(123)-456-7890");

        parameters.put("first_name", request.getFirstName());
        parameters.put("last_name", request.getLastName());
        parameters.put("active", request.getActive());
        parameters.put("email", request.getEmail());
        parameters.put("phone", request.getPhone());

        sandboxHeader.setSandboxHeaderKey("Content-Type");
        sandboxHeader.setSandboxHeaderValue("application/json");

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandUser);        //adds to the body

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 201);

        System.out.println("Response Status Code Returned is: " + response.getStatusLine());

    }

    @Test
    public void sandboxUsersAssertHeaderValidate() throws JSONException {
        RestAssured.baseURI = apiConstants.sandBaseURL;

        RequestSpecification httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);

        request.setFirstName("Elizabeth");
        request.setLastName("Feng");
        request.setActive(true);
        request.setEmail("elizabethfengabcdefghijklmnopqrstuvwxyz@gmail.com");  //need to change email to run
        request.setPhone("(123)-456-7890");

        parameters.put("first_name", request.getFirstName());
        parameters.put("last_name", request.getLastName());
        parameters.put("active", request.getActive());
        parameters.put("email", request.getEmail());
        parameters.put("phone", request.getPhone());

        sandboxHeader.setSandboxHeaderKey("Content-Type");
        sandboxHeader.setSandboxHeaderValue("application/json");

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandUser);        //adds to the body

        String headerKey = String.valueOf(response.getHeaders().get("content-type"));
        Assert.assertTrue(String.valueOf(headerKey.contains("content-Type")), true);
        System.out.println(headerKey);

    }

    @Test
    public void sandboxUsersValidateResponse() throws JSONException {
        RestAssured.baseURI = apiConstants.sandBaseURL;

        RequestSpecification httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);

        request.setFirstName("Elizabeth");
        request.setLastName("Feng");
        request.setActive(true);
        request.setEmail("elizabethabcdefghijklmnopqrstuvwxyz1234@gmail.com");  //need to change email to run
        request.setPhone("(123)-456-7890");

        parameters.put("first_name", request.getFirstName());
        parameters.put("last_name", request.getLastName());
        parameters.put("active", request.getActive());
        parameters.put("email", request.getEmail());
        parameters.put("phone", request.getPhone());

        sandboxHeader.setSandboxHeaderKey("Content-Type");
        sandboxHeader.setSandboxHeaderValue("application/json");

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandUser);        //adds to the body

        jsonResponse.setStatus(String.valueOf("ACTIVE"));
        Assert.assertTrue(String.valueOf(response.prettyPrint().contains(jsonResponse.getStatus())), true);
        System.out.println(jsonResponse.getStatus());
    }

}