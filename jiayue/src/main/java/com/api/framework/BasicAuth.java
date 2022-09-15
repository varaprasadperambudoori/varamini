package com.api.framework;

import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.hamcrest.Matchers.*;






import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;



public class BasicAuth {
    @Test
    public void getResponse() throws IOException, ParseException {
        List<String> fileContant = new Constant("baseURLs").getList();

        System.out.println(fileContant.get(1));
        RestAssured.baseURI = fileContant.get(1);

        JSONParser parser = new JSONParser();
        JSONArray requests = (JSONArray) parser.parse(new FileReader("/Users/jiayue/Downloads/varamini/jiayue/src/main/resources/request.json"));
        JSONObject request = (JSONObject) requests.get(0);


        RequestSpecification httpRequest = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");

        httpRequest.given().when()
                .body(request.toJSONString())
                .post()
                .then().
                log().all()
                .assertThat().statusCode(200).body("first_name",equalTo("Jiayue"));

    }




}