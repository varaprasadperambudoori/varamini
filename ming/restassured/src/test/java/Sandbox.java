package restassured.src.test.java;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import restassured.src.main.java.com.api.framework.RestUtil;

import static restassured.src.main.java.com.api.framework.Constant.*;

public class Sandbox {
    public Response response;


    @Test
    public void testCreateProgram() {
        response = RestUtil.createProgram("Program Mini");
        Assert.assertEquals(201, response.getStatusCode());
    }

}
