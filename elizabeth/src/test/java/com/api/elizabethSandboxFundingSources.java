package com.api;

import com.api.object.Body.SandboxFundingSourcesBody;
import com.api.object.Header.SandboxHeaders;
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
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.HashMap;
import java.util.Map;

public class elizabethSandboxFundingSources {
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

        RestAssured.baseURI = apiConstants.sandBaseURL;
            log.info("Navigate BaseURI");

        RequestSpecification httpRequest = RestAssured.given().auth().basic(apiConstants.username, apiConstants.password);
            log.info("Basic authentication provided");

        JSONObject parameters = new JSONObject();

        parameters.put("name", "Program Mini");
            log.info("Body added");


          SandboxHeaders sandboxHeader = new SandboxHeaders();
          sandboxHeader.setSandboxHeaderKey("Content-Type");
          sandboxHeader.setSandboxHeaderValue("application/json");

        httpRequest.header(sandboxHeader.getSandboxHeaderKey(), sandboxHeader.getSandboxHeaderValue());

        httpRequest.body(parameters.toString());

        Response response = httpRequest.request(Method.POST, apiConstants.sandProgram);		//adds to the body
            log.info("Post method");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 201);
            log.info("Compared expected and actual status codes");

        System.out.println("Response Status Code Returned is: " +response.getStatusLine());

            log.info(response.prettyPrint());

            log.info("Printed response");

            String jsonOutput = response.prettyPrint();

        JSONAssert.assertEquals("{name:\"Program Mini\"}", jsonOutput, false);

            log.info("Asserted JSON Data");

        }
}
