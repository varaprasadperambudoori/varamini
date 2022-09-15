package com.api.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.util.Properties;

import static com.api.framework.Constant.*;

public class UserEndpoints {
    static Properties prop = new Properties();
    static Response response;
    static FileInputStream file;
    public static Response createUser(String userPayload) throws IOException {
        file = new FileInputStream("./src/main/resources/config.properties");
        prop.load(file);
        RestAssured.baseURI  = prop.getProperty("baseUrl");
        response = RestAssured
                .given()
                .auth()
                .basic(username, password)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userPayload)
                .when()
                .post(create_user);
        return response;
    }

    public static Response getSingleUserByFirstName(String first_name) throws IOException {
        file = new FileInputStream("./src/main/resources/config.properties");
        prop.load(file);
        RestAssured.baseURI  = prop.getProperty("baseUrl");

        response = RestAssured
                .given()
                .auth()
                .basic(username, password)
                .pathParam("first_name",first_name)
                .when().get(get_single_user);

        return response;
    }

    public static Response getAllUsers() throws IOException {
        file = new FileInputStream("./src/main/resources/config.properties");
        prop.load(file);
        RestAssured.baseURI  = prop.getProperty("baseUrl");
        Response response = RestAssured
                .given()
                .auth()
                .basic(username, password)
                .when().get(get_all_users);

        return response;
    }

}