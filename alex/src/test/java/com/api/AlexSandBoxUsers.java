package com.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlexSandBoxUsers{

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

        param.put("first_name", "Alex");
        param.put("last_name", "Vuong");
        param.put( "active", true);
        param.put("email", "avuong@fakemail.com");
        param.put( "phone","(123)-456-7890");

        logger.info("Made request to SandBox API with users using Post Method");
        RestAssured
                .given()
                    .auth()
                    .preemptive()
                    .basic(Constants.username, Constants.password)
                    .contentType(ContentType.JSON)
                    .body(param.toString())
                .when().
                    post(Constants.sandBaseURL + Constants.sandUser)
                .then()
                    .assertThat()
                    .statusCode(201)
                    .log()
                    .body();
        logger.info("Printed body of the post method to console");
    }
}
