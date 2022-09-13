package RestAssuredFramework;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class JsonCall {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://sandbox-api.marqeta.com/v3/fundingsources/program";
		RequestSpecification request = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146");
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Program Mini");
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.post(); 
		System.out.println(response.body().asString());
		
	}
}
