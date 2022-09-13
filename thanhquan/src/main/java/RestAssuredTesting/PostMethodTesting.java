package RestAssuredTesting;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;


class PostMethodTesting {
    static RequestSpecification request;
    static JSONObject requestParams = new JSONObject();
    static Response response;
    static JsonPath jsonPath;

    @BeforeAll
    static void setUp() throws Exception {
        RestAssured.baseURI = "https://sandbox-api.marqeta.com/v3/fundingsources/program";
        request = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");
        requestParams.put("name", "Program Mini");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        response = request.post();
    }

    @Test
    void statusCodeTest() {
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(201, statusCode);
    }

    @Test
    void bodyTest() {
        String expected = "Program Mini";
        jsonPath = response.jsonPath();
        Assertions.assertEquals(expected, jsonPath.get("name"));

    }
}

