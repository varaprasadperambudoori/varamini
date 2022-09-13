import org.json.simple.JSONObject;
//import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class joshuaSandBox {
	@Test
	public void sandBoxPost() {
		
		JSONObject params = new JSONObject();

		params.put("name", "Program Mini");
		
		
		RestAssured
		.given()
			.auth()
			.preemptive()
			.basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb", "5f791fce-154f-4d7f-ba7a-a4b44212a146")
			.contentType(ContentType.JSON)
			.body(params.toString())
		.when()
			.post("https://sandbox-api.marqeta.com/v3/fundingsources/program")
		.then()
			.assertThat()
				.statusCode(201)
				.log()
					.body();
	}

}