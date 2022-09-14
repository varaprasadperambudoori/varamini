import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

public class AlexRestAssured {
    @Test
    public void post(){
        JSONObject param = new JSONObject();
        param.put("name", "Program Mini");

        RestAssured
                .given()
                    .auth()
                    .preemptive()
                    .basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146")
                    .contentType(ContentType.JSON)
                    .body(param.toString())
                .when().
                    post("https://sandbox-api.marqeta.com/v3/fundingsources/program")
                .then()
                    .assertThat()
                    .statusCode(201)
                    .log()
                .body();
    }
}