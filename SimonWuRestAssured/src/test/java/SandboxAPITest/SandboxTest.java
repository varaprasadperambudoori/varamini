package SandboxAPITest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.logging.log4j.io.IoBuilder;

public class SandboxTest {
    private static final Logger LOGGER= LogManager.getLogger(SandboxTest.class);
    String user="c598a04a-5c04-4dad-a5b5-d5dfc66e5feb";
    String password = "5f791fce-154f-4d7f-ba7a-a4b44212a146";
    //program mini token
    String token = "27e5e431-8459-4421-a00f-379624c9a5ad";
    //static PrintStream log;
    @BeforeClass
    public static void setup(){
        RestAssured.baseURI="https://sandbox-api.marqeta.com/v3/";
        //log = IoBuilder.forLogger(SandboxTest.class).setLevel(Level.ALL).buildPrintStream();
        //System.setOut(log);
        //ToLogger
        //RestAssured.config = RestAssured.config().logConfig(new LogConfig());

        LOGGER.info("Setup base uri");
    }

    @Test
    public void createProgramSource(){
        System.out.println(RestAssured.baseURI);
        JSONObject json = new JSONObject();
        json.put("name","Program Mini");
        RequestSpecification req = RestAssured.given()
                .auth().basic(user,password);

        Response res = req.header("Content-Type","application/json")
                .body(json.toString())
                .post("fundingsources/program");
        Assert.assertEquals(201,res.getStatusCode());
        LOGGER.info("Pass createProgramSource\nStatus Code : "+res.getStatusCode()
                +" Payload: "+res.getBody().prettyPrint());
    }

    @Test
    public void getProgramSource(){
        System.out.println(RestAssured.baseURI);
        JSONObject json = new JSONObject();
        json.put("name","Program Mini");
        RequestSpecification req = RestAssured.given()
                .auth().basic(user,password);

        Response res = req.accept(ContentType.JSON).get("fundingsources/program/"+token);

        /*RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        RequestSpecification req = reqBuilder.setBaseUri("https://sandbox-api.marqeta.com/v3/").log(LogDetail.ALL).build();

        Response res = RestAssured.given(req).auth().basic(user,password).accept(ContentType.JSON).get("fundingsources/program/"+token);

         */
        Assert.assertEquals(200,res.getStatusCode());
        LOGGER.info("Pass getProgramSource\nStatus Code : "+res.getStatusCode()
                +" Payload: "+res.getBody().prettyPrint());
    }


}
