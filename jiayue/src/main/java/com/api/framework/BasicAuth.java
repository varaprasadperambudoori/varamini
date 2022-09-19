package com.api.framework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.hamcrest.Matchers.*;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;



public class BasicAuth {
    @Test
    public void getResponse() throws IOException, ParseException {
        List<String> fileContant = new Constant().getList();

        System.out.println(fileContant.get(1));
        RestAssured.baseURI = fileContant.get(1);

        JSONParser parser = new JSONParser();
        JSONArray requests = (JSONArray) parser.parse(new FileReader("jiayue/src/main/resources/request.json "));
        JSONObject request = (JSONObject) requests.get(0);


        RequestSpecification httpRequest = RestAssured.given().contentType("application/json; charset=utf-8").auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");

        Response response = httpRequest.body(request.toJSONString()).when().post();

        response
                .then().
                log().all()
                .assertThat().statusCode(201).body("first_name",equalTo("Paul"));


        FileWriter file = new FileWriter("./output.json");
        file.write(response.getBody().asString());
        file.flush();
        file.close();

    }




}