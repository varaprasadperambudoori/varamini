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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateProgramTesting {

    private static FundingsourcesProgramRequest fundingsourcesProgramRequest;
    private static FundingsourcesProgramResponse fundingsourcesProgramResponse;
    private static Logger log = LogManager.getLogger(CreateProgramTesting.class);

    @BeforeAll
    static void setUp() throws Exception {
        ReportGenerator.setUp();
    }

    @Test
    void createProgramTest() throws Exception {
        String programName = "Program Mini 02 Testing";
        fundingsourcesProgramRequest = new FundingsourcesProgramRequest();
        fundingsourcesProgramRequest.setProgramName(programName);
        log.info("Set program name: " + programName);
        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("name", fundingsourcesProgramRequest.getProgramName());
        String payload = new Gson().toJson(bodyParams);
        log.info("Set request data: " + payload);
        Response response= UserEndpoints.createProgram(payload);
        log.info("Creating program...!!!");
        fundingsourcesProgramResponse = response.getBody().as(FundingsourcesProgramResponse.class);
        // Assertion
        Assertions.assertEquals(201,response.statusCode());
        Assertions.assertEquals(programName, fundingsourcesProgramResponse.getName());
        reportLog("Get All Users Testing","Status Code Response is 200");
    }

    @AfterAll
    static void tearDown() throws Exception {
        reportGenerate();
    }

}
