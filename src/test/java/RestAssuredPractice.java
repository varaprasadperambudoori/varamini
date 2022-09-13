import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.json.JSONObject;



public class RestAssuredPractice {
    public static void testPost() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Program Mini");
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(jsonObject.toString())
                    .auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146")
                    .log().all()
                .when()
                    .post("https://sandbox-api.marqeta.com/v3/fundingsources/program")
                .then()
                    .assertThat().statusCode(201)
                    .body("name", equalTo("Program Mini"))
                    .body("active", equalTo(true))
                    .log().all();
    }

}
