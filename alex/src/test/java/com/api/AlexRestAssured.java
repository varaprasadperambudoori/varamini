package com.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlexRestAssured {

    static Logger logger = LogManager.getLogger();

    @BeforeClass
    public static void setUp() {
        logger.info("Hello, Logger has started");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        logger.info("Logger completed. Good Bye");
    }
    @Test
    public void post(){

        logger.info("Initialized JSONObject for POST Method");
        JSONObject param = new JSONObject();
        param.put("name", "Program Mini");

        logger.info("Made request to SandBox API using Post Method");
        RestAssured
                .given()
                    .auth()
                    .preemptive()
                    .basic(Constants.username, Constants.password)
                    .contentType(ContentType.JSON)
                    .body(param.toString())
                .when().
                    post(Constants.sandBaseURL + Constants.sandProgram)
                .then()
                    .assertThat()
                    .statusCode(201)
                    .log()
                    .body();
        logger.info("Printed body of the post method to console");
    }
}