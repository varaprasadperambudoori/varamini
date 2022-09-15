package com.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.File;
import java.io.FileWriter;

public class elizabethSandboxUsers {
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
        public void sandboxRestAssuredUsers() throws JSONException {
            log.info("Logging Sandbox Users");

            RestAssured.baseURI = apiConstants.sandBaseURL;
            log.info("Navigate BaseURI");

            RequestSpecification httpRequest = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");
            log.info("Basic authentication provided");

            JSONObject parameters = new JSONObject();

            parameters.put("first_name", "Elizabeth");
            parameters.put("last_name", "Feng");
            parameters.put("active", true);
            parameters.put("email", "elizabethfengabcdefghijklmnopqrs@gmail.com");      //need to change email to run
            parameters.put("phone", "(123)-456-7890");

            log.info("Body added");

            httpRequest.header("Content-Type", "application/json");

            httpRequest.body(parameters.toString());

            Response response = httpRequest.request(Method.POST, apiConstants.sandUser);		//adds to the body

            log.info("Post method");

            int statusCode = response.getStatusCode();

            Assert.assertEquals(statusCode, 201);

            log.info("Compared expected and actual status codes");

            System.out.println("Response Status Code Returned is: " +response.getStatusLine());

            log.info(response.prettyPrint());

            log.info("Printed response");

            String jsonOutput = response.prettyPrint();

            JSONAssert.assertEquals("{first_name:\"Elizabeth\"}", jsonOutput, false);

            log.info("Asserted JSON Data");

        }


}
