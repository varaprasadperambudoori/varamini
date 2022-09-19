package com.api.framework;

import com.api.pojo.PojoUtil;
import com.api.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static com.api.framework.Constant.*;

public class RestUtil {

    public static Response createProgram(RequestSpecification request, String name) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        Response response = request.contentType(ContentType.JSON)
                                    .body(jsonObject.toString())
                                    .post(PROGRAM);
        return response;
    }

    public static Response createUser(RequestSpecification request, String fName, String lName, String email, String phone) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("first_name", fName);
//        jsonObject.put("last_name", lName);
//        jsonObject.put("active", true);
//        jsonObject.put("email", email);
//        jsonObject.put("phone", phone);
        User user = new User();
        user.setActive(true);
        user.setFirst_name(fName);
        user.setLast_name(lName);
        user.setEmail(email);
        user.setPhone(phone);
        Response response = request.contentType(ContentType.JSON)
                                    .body(PojoUtil.getJsonFromUser(user))
                                    .post(USER);
        return response;
    }

    public static Response getUsers(RequestSpecification request) {
        Response response = request.get(USER);
        return response;
    }

    public static Response getUser(RequestSpecification request, String fName, String lName) {
        Response response = request.queryParam("first_name", fName)
                                    .queryParam("last_name", lName)
                                    .get(USER);
        return response;
    }

}
