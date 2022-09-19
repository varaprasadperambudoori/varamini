package stepDef;

import com.api.framework.RestUtil;
import com.api.pojo.PojoUtil;
import com.api.pojo.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static com.api.framework.Constant.*;

public class SandboxCreateUserDef {
    User user;
    Response response;
    RequestSpecification request;


    @Given("I have an user object")
    public void i_have_an_user_object() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        user = new User();
        user.setFirst_name("Jackson");
        user.setLast_name("Swift");
        user.setEmail("jkjk333@yahoo.com");
        user.setPhone("2153349853");
        user.setActive(true);
    }

    @When("I send post request with user data as body to Sandbox api")
    public void i_send_post_request_with_user_data_as_body_to_sandbox_api() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = "https://sandbox-api.marqeta.com/v3";
        request = RestAssured.given().auth().basic("c598a04a-5c04-4dad-a5b5-d5dfc66e5feb","5f791fce-154f-4d7f-ba7a-a4b44212a146");
        response = request.contentType(ContentType.JSON)
                            .body(PojoUtil.getJsonFromUser(user))
                            .post(USER);
    }

    @Then("I should get a response with status code {int}")
    public void i_should_get_a_response_with_status_code(Integer int1) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(201, response.getStatusCode());
    }
}
