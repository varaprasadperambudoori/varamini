package com.api.framework;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;


public class joshuaSandboxAPIRestAssured {



    public static Logger log = LogManager.getLogger();
    @Test
    public void sandBoxProgramPost() throws JSONException {
        log.info("POST FOR SANDBOX PROGRAM STARTED");
        log.info("Made JSON object to hold the body for program post method");
        JSONObject par = new JSONObject();

        par.put("name", "Program Mini");

        log.info("Made request to Sandbox API with program post method");
        Response res = given()
                    .auth()
                    .preemptive()
                    .basic(Constant.username, Constant.password)
                    .contentType(ContentType.JSON)
                    .body(par.toString())
                .when()
                    .post(Constant.Program);

        log.info("Adding assert to check post");

        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, 201);

        String output = res.prettyPrint();

        JSONAssert.assertEquals("{name:\"Program Mini\"}", output, false);

        log.info("print body of post method to log");
        log.info(res.prettyPrint());

        log.info("print body of the post method to console");
        System.out.println(res.prettyPrint());


        log.info("POST FOR SANDBOX PROGRAM ENDED");
    }

    @Test
    public void sandBoxUsersPost() throws JSONException{

        log.info("POST FOR SANDBOX USERS STARTED");

        log.info("Made JSON object to hold the body for users post method");
        JSONObject par = new JSONObject();

        par.put("first_name", "Joshua");
        par.put("last_name", "Cabrera");
        par.put( "active", true);
        par.put("email", "jcabrera1921@mailinator.com");
        par.put( "phone","(123)-456-7890");


        log.info("Made request to Sandbox API with users post method");
        Response res = given()
                .auth()
                .preemptive()
                .basic(Constant.username, Constant.password)
                .contentType(ContentType.JSON)
                .body(par.toString())
                .when()
                .post(Constant.Users);


        log.info("print body of post method to log");
        log.info(res.prettyPrint());

        log.info("print body of the post method to console");
        System.out.println(res.prettyPrint());

        log.info("Adding assert to check post");

        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, 201);

        String output = res.prettyPrint();

        JSONAssert.assertEquals("{first_name:\"Joshua\"}", output, false);

        log.info("print body of the post method to console");
        System.out.println(res.prettyPrint());

        log.info("POST FOR SANDBOX USERS ENDED");
    }


}