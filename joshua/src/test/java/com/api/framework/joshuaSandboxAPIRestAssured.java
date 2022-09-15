package com.api.framework;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import base.baseClass;
public class joshuaSandboxAPIRestAssured extends baseClass{


    @Test
    public void sandBoxProgramPost() {

        log.info("Made JSON object to hold the body for program post method");
        JSONObject par = new JSONObject();

        par.put("name", "Program Mini");

        log.info("Made request to Sandbox API with program post method");
        RestAssured
                .given()
                    .auth()
                    .preemptive()
                    .basic(Constant.username, Constant.password)
                    .contentType(ContentType.JSON)
                    .body(par.toString())
                .when()
                    .post(Constant.Program)
                .then()
                    .assertThat()
                    .statusCode(201)
                    .log()
                        .body();
        log.info("print body of the post method to console");
    }

    @Test
    public void sandBoxUsersPost(){

        log.info("Made JSON object to hold the body for users post method");
        JSONObject par = new JSONObject();

        par.put("first_name", "Joshua");
        par.put("last_name", "Cabrera");
        par.put( "active", true);
        par.put("email", "jcabrera12@mailinator.com");
        par.put( "phone","(123)-456-7890");


        log.info("Made request to Sandbox API with users post method");
        RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(Constant.username, Constant.password)
                .contentType(ContentType.JSON)
                .body(par.toString())
                .when()
                .post(Constant.Users)
                .then()
                .assertThat()
                .statusCode(201)
                .log().body();

        log.info("print body of the post method to console");
    }


}