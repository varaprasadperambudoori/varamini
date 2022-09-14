import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BasicAuth {
    @Test
    public void getUserData() {
        RestAssured.baseURI = "https://sandbox-api.marqeta.com/v3/fundingsources/program";
        RequestSpecification httpRequest = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Program Mini");
        httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        Response res = httpRequest.post();
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }
}