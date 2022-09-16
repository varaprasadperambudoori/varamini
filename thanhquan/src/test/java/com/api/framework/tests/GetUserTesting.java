package com.api.framework.tests;

import com.api.framework.ReportGenerator;
import com.api.framework.UserEndpoints;
import com.api.framework.pojoRequest.UserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.api.framework.ReportGenerator.reportGenerate;
import static com.api.framework.ReportGenerator.reportLog;


public class GetUserTesting {

    private UserRequest userRequest;

    @BeforeAll
    static void setUp() throws Exception {
        ReportGenerator.setUp();
    }

    @Test
    void getAllUsersTest() throws IOException {
        Response response = UserEndpoints.getAllUsers();
        int statusCode = response.getStatusCode();
        System.out.println(response.body().prettyPrint());
        Assertions.assertEquals(200,statusCode);
        reportLog("Get All Users Testing","Status Code Response is 200");
    }

    @Test
    void getSingleUserByFirstNameTest() throws IOException {
        userRequest = new UserRequest();
        userRequest.setFirst_name("Quan");
        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("first_name", userRequest.getFirst_name());
        Response response = UserEndpoints.getSingleUserByFirstName(this.userRequest.getFirst_name());
        int statusCode = response.getStatusCode();
        System.out.println(response.body().prettyPrint());
        Assertions.assertEquals(200,statusCode);
        reportLog("Get User By First Name Testing","Status Code Response is 200");

    }

    @AfterAll
    static void tearDown() throws Exception {
        reportGenerate();
    }
}
