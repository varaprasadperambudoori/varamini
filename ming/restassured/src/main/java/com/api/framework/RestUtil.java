package restassured.src.main.java.com.api.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static restassured.src.main.java.com.api.framework.Constant.*;

public class RestUtil {

    public static Response createProgram(String name) {
        RestAssured.baseURI = "https://sandbox-api.marqeta.com/v3";
        RequestSpecification request = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb","5f791fce-154f-4d7f-ba7a-a4b44212a146");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        Response response = request.contentType(ContentType.JSON)
                                    .body(jsonObject.toString())
                                    .post(CREATE_PROGRAM);
        return response;
    }
}
