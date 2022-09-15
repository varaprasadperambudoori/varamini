package com.api.framework.tests;

import com.api.framework.DataSetUp;
import com.api.framework.ReportGenerator;
import com.api.framework.UserEndpoints;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.api.framework.ReportGenerator.*;


public class Testing {

    private DataSetUp dataSetUp;

    @BeforeAll
    static void setUp() throws Exception {
        ReportGenerator.setUp();
    }

    @Test
    void getAllUsersTest() throws IOException {
        Response response = UserEndpoints.getAllUsers();
        int statusCode = response.getStatusCode();
//        System.out.println(response.body().prettyPrint());
        Assertions.assertEquals(200,statusCode);
        reportLog("Get All Users Testing","Status Code Response is 200");
    }

    @Test
    void getSingleUserByFirstNameTest() throws IOException {
        dataSetUp = new DataSetUp();
        dataSetUp.setFirst_name("Quan");
        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("first_name", dataSetUp.getFirst_name());
        Response response = UserEndpoints.getSingleUserByFirstName(this.dataSetUp.getFirst_name());
        int statusCode = response.getStatusCode();
//        System.out.println(response.body().prettyPrint());
        Assertions.assertEquals(200,statusCode);
        reportLog("Get User By First Name Testing","Status Code Response is 200");

    }

    @Test
    void createUserTest() throws IOException {

        dataSetUp = new DataSetUp();
        dataSetUp.setFirst_name("test01 first name");
        dataSetUp.setLast_name("test01 last name");
        dataSetUp.setActive(true);
        dataSetUp.setEmail("test01@gmail.com");
        dataSetUp.setPhone("(123)-456-7890");

        Map<String, Object> bodyParams = new HashMap<String, Object>();

        bodyParams.put("first_name", dataSetUp.getFirst_name());
        bodyParams.put("last_name", dataSetUp.getLast_name());
        bodyParams.put("active", dataSetUp.isActive());
        bodyParams.put("email", dataSetUp.getEmail());
        bodyParams.put("phone", dataSetUp.getPhone());

        String payload = new Gson().toJson(bodyParams);
        Response response= UserEndpoints.createUser(payload);
        Assertions.assertEquals(response.getStatusCode(),201);
        reportLog("User Create Testing","Status Code Response is 201");
    }

    @AfterAll
    static void tearDown() throws Exception {
        reportGenerate();
    }
}
