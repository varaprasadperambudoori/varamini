package com.api.framework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static src.main.java.com.api.framework.Constant.*;

public class RestUtil {

    public static Response createProgram(RequestSpecification request, String name) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        Response response = request.contentType(ContentType.JSON)
                                    .body(jsonObject.toString())
                                    .post(CREATE_PROGRAM);
        return response;
    }

    public static Response createUser(RequestSpecification request, String fName, String lName, String email, String phone) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("first_name", fName);
        jsonObject.put("last_name", lName);
        jsonObject.put("active", true);
        jsonObject.put("email", email);
        jsonObject.put("phone", phone);
        Response response = request.contentType(ContentType.JSON)
                                    .body(jsonObject.toString())
                                    .post(CREATE_USER);
        return response;
    }

}
