package com.api.framework.tests;

import com.api.framework.PojoResponse.FundingsourcesProgramResponse;
import com.api.framework.pojoRequest.FundingsourcesProgramRequest;
import com.api.framework.ReportGenerator;
import com.api.framework.UserEndpoints;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.api.framework.ReportGenerator.reportGenerate;
import static com.api.framework.ReportGenerator.reportLog;

public class CreateProgramTesting {

    private static FundingsourcesProgramRequest fundingsourcesProgramRequest;
    private static FundingsourcesProgramResponse fundingsourcesProgramResponse;

    @BeforeAll
    static void setUp() throws Exception {
        ReportGenerator.setUp();
    }

    @Test
    void createProgramTest() throws Exception {

        fundingsourcesProgramRequest = new FundingsourcesProgramRequest();
        fundingsourcesProgramRequest.setProgramName("Program Mini 02 Testing");

        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("name", fundingsourcesProgramRequest.getProgramName());

        String payload = new Gson().toJson(bodyParams);
        Response response= UserEndpoints.createProgram(payload);

        fundingsourcesProgramResponse = response.getBody().as(FundingsourcesProgramResponse.class);

        // Assertion
        Assertions.assertEquals(201,response.statusCode());
        Assertions.assertEquals("Program Mini 02 Testing", fundingsourcesProgramResponse.getName());

        reportLog("Get All Users Testing","Status Code Response is 200");
    }

    @AfterAll
    static void tearDown() throws Exception {
        reportGenerate();
    }

}
