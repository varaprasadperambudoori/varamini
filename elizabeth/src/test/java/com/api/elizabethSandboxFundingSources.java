package com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class elizabethSandboxFundingSources {
    public static void main(String[] args) {

        RestAssured.baseURI = apiConstants.sandBaseURL;

        RequestSpecification httpRequest = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");

        JSONObject parameters = new JSONObject();

        parameters.put("name", "Program Mini");

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandProgram);		//adds to the body

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 201);

        System.out.println("Response Status Code Returned is: " +response.getStatusLine());

        response.prettyPrint();


    }
}
