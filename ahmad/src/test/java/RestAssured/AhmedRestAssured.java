package RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class AhmedRestAssured {
    private static Logger logger = LogManager.getLogger(AhmedRestAssured.class);

    public static void main(String[] args) {

        RestAssured.baseURI = ApiLinks.BaseURL;
        logger.info("Used baseurl from APILinks file");
        RequestSpecification httpRequest = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146").contentType("application/json; charset=utf-8");
        logger.info("Added credentials for api");
        httpRequest.basePath(ApiLinks.program);
        logger.info("Changed path and added the program addition");
        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("name", "Program Mini");
        JSONObject obj = new JSONObject(jsonMap);
        logger.info("Created JsonObject");
        Response response = httpRequest.body(obj.toString()).post();
        logger.info("Sent Body containing JsonObject");
        Assert.assertEquals(201,response.statusCode() );
        logger.info("Asserted that status code is 201 successful");

        response.prettyPrint();
        logger.info(response.prettyPrint());

    }
}