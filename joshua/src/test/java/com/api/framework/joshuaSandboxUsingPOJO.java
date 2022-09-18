package com.api.framework;

import com.api.framework.pojoRequest.sandboxProgramRequest;
import com.api.framework.pojoRequest.sandboxUsersRequest;
import com.api.framework.pojoResponse.sandboxProgramResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class joshuaSandboxUsingPOJO {

    public static Logger log = LogManager.getLogger();
    public static sandboxProgramRequest sandProgramReq = new sandboxProgramRequest();

    public static sandboxUsersRequest sandUserReq = new sandboxUsersRequest();

    @Test
    public void sandBoxProgramPOJO() throws JSONException{
        log.info("POST FOR SANDBOX PROGRAM using POJO STARTED");

        sandProgramReq.setName("Program Mini");

        JSONObject par = new JSONObject();
        par.put("name", sandProgramReq.getName());

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

        log.info("POST FOR SANDBOX PROGRAM ENDED");

    }

    @Test
    public void sandBoxUsersPost() throws JSONException {
        log.info("POST FOR SANDBOX USERS USING POJO STARTED");

        log.info("Made JSON object to hold the body for users post method");
        JSONObject par = new JSONObject();

        sandUserReq.setFirstName("Joshua");
        sandUserReq.setLastName("Cabrera");
        sandUserReq.setActive(true);
        sandUserReq.setEmail("jcabrera0912@mailinator.com");
        sandUserReq.setPhone("(123)-456-7890");

        par.put("first_name", sandUserReq.getFirstName());
        par.put("last_name", sandUserReq.getLastName());
        par.put( "active", sandUserReq.getActive());
        par.put("email", sandUserReq.getEmail());
        par.put( "phone",sandUserReq.getPhone());

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

        log.info("Adding assert to check post");

        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, 201);

        String output = res.prettyPrint();

        JSONAssert.assertEquals("{first_name:\"Joshua\"}", output, false);
        JSONAssert.assertEquals("{last_name:\"Cabrera\"}", output, false);
        JSONAssert.assertEquals("{email:\"jcabrera0912@mailinator.com\"}", output, false);
        JSONAssert.assertEquals("{phone:\"(123)-456-7890\"}", output, false);

        log.info("print body of the post method to console");
        System.out.println(res.prettyPrint());

        log.info("POST FOR SANDBOX USERS ENDED");
    }
}
