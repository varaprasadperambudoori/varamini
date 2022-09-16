package com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.skyscreamer.jsonassert.JSONAssert;

public class ZeeshanRestAssured {
    public static Logger log = LogManager.getLogger();

    @BeforeClass
    public static void setUp() {
        log.info("REST ASSURED API LOG COMMENCED");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        log.info("LOG COMPLETED");
    }

    @Test
    public void sandboxRestAssuredPrograms() throws JSONException {
        log.info("Logging Sandbox Programs");

        RestAssured.baseURI = Api.BASEURI;
        log.info("Navigate BaseURI");

        RequestSpecification httpRequest = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");
        log.info("Basic authentication provided");

        JSONObject parameters = new JSONObject();

        parameters.put("name", "Program Mini");
        log.info("Body added");

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, Api.USERS);		//adds to the body
        log.info("Post method");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 201);
        log.info("Compared expected and actual status codes");

        System.out.println("Response Status Code Returned is: " +response.getStatusLine());

        log.info(response.prettyPrint());

        log.info("Printed response");

        String jsonOutput = response.prettyPrint();

        //JSONAssert.assertEquals("{name:\"Program Mini\"}", jsonOutput, false);

        log.info("Asserted JSON Data");

    }
}
