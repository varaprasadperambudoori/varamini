package RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AhmedRestAssuredUsers {
    public static Logger logger = LogManager.getLogger(AhmedRestAssuredUsers.class);


    public static void main(String[] args) {

        RestAssured.baseURI = ApiLinks.BaseURL;
        logger.info("Used baseurl from APILinks file");

        RequestSpecification httpRequest = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146").contentType("application/json; charset=utf-8");
        logger.info("Basic authentication provided");
        httpRequest.basePath(ApiLinks.users);
        logger.info("Added user extension from APILinks file");
        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("first_name", "Ahmed");
        jsonMap.put("last_name", "Damanhoury");
        jsonMap.put("email", "Andamanhoury467@gmail.com");
        jsonMap.put("phone", "(123)-456-7890");
        logger.info("Filled Map with objects to inject into JsonObject");
        JSONObject obj = new JSONObject(jsonMap);
        logger.info("Created JsonObject");
        Response response = httpRequest.body(obj.toString()).post();
        logger.info("Sent Body");
        Assert.assertEquals(response.getStatusCode(), 201);
        logger.info("Status Code = 201");
        response.prettyPrint();
        logger.info(response.prettyPrint());

    }
}