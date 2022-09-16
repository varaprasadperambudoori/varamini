package src.test.java;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.api.framework.RestUtil;



public class Sandbox {
    public static RequestSpecification request;
    public static Response response;
    private static Logger logger = LogManager.getLogger(Sandbox.class);

    @BeforeClass
    public static void setup() {
        logger.info("Setting up base URI");
        RestAssured.baseURI = "https://sandbox-api.marqeta.com/v3";
        request = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb","5f791fce-154f-4d7f-ba7a-a4b44212a146");
        logger.info("Set up successfully!");
    }


    @Test
    public void testCreateProgram() {
        logger.info("Start testing creating program");
        response = RestUtil.createProgram(request,"Program Mini");
        String name = response.body().jsonPath().getString("name");
        boolean active = response.body().jsonPath().getBoolean("active");
        Assert.assertEquals(201, response.getStatusCode());
        logger.info("Status code assertion passed!");
        Assert.assertEquals("Program Mini", name);
        logger.info("Program name assertion passed!");
        Assert.assertTrue(active);
        logger.info("Active status assertion passed!");
        logger.info("Creating program test passed!");
    }

    @Test
    public void testCreateUser() {
        logger.info("Start testing creating user");
        response = RestUtil.createUser(request, "Varaprasad", "Perambudoori", "varamarqeta6637@mailinator.com", "(949)-572-4426");
        String fName = response.body().jsonPath().getString("first_name");
        String lName = response.body().jsonPath().getString("last_name");
        boolean active = response.body().jsonPath().getBoolean("active");
        String email = response.body().jsonPath().getString("email");
        String phone = response.body().jsonPath().getString("phone");
        Assert.assertEquals(201, response.getStatusCode());
        logger.info("Status code assertion passed!");
        Assert.assertEquals("Varaprasad", fName);
        logger.info("First name assertion passed!");
        Assert.assertEquals("Perambudoori", lName);
        logger.info("Last name assertion passed!");
        Assert.assertEquals("varamarqeta6637@mailinator.com", email);
        logger.info("Email assertion passed!");
        Assert.assertEquals("(949)-572-4426", phone);
        logger.info("Phone assertion passed!");
        Assert.assertTrue(active);
        logger.info("Active status assertion passed!");
        logger.info("Creating user test passed!");
    }

}
