package com.api.framework.tests;

import com.api.framework.PojoResponse.UserReponse;
import com.api.framework.pojoRequest.UserRequest;
import com.api.framework.ReportGenerator;
import com.api.framework.UserEndpoints;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.api.framework.ReportGenerator.*;


public class CreateUserTesting {

    private static UserRequest userRequest;
    private static UserReponse userReponse;

    private static Logger log = LogManager.getLogger(CreateUserTesting.class);
    @BeforeAll
    static void setUp() throws Exception {
        ReportGenerator.setUp();
    }

    @Test
    void createUserTest() throws IOException {
        log.info("---Create User---");
        userRequest = new UserRequest();
        userRequest.setFirst_name("test05 first name");
        userRequest.setLast_name("test05 last name");
        userRequest.setActive(true);
        userRequest.setEmail("test05@gmail.com");
        userRequest.setPhone("(123)-456-7890");
        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("first_name", userRequest.getFirst_name());
        log.info("Set first name: " + userRequest.getFirst_name());

        bodyParams.put("last_name", userRequest.getLast_name());
        log.info("Set last name: " + userRequest.getLast_name());

        bodyParams.put("active", userRequest.isActive());
        log.info("Set active: " + userRequest.isActive());

        bodyParams.put("email", userRequest.getEmail());
        log.info("Set email: " + userRequest.getEmail());

        bodyParams.put("phone", userRequest.getPhone());

        String payload = new Gson().toJson(bodyParams);
        Response response= UserEndpoints.createUser(payload);
        log.info("Setting request body: " + payload);
        userReponse = response.getBody().as(UserReponse.class);
        // Assertion
        Assertions.assertEquals(201,response.statusCode());
        Assertions.assertEquals("test04 first name", userReponse.getFirstName());
        Assertions.assertEquals("test04 last name", userReponse.getLastName());
        Assertions.assertEquals("test04@gmail.com", userReponse.getEmail());
        Assertions.assertEquals("(123)-456-7890", userReponse.getPhone());

    }

    @AfterAll
    static void tearDown() throws Exception {
        reportGenerate();
    }
}
