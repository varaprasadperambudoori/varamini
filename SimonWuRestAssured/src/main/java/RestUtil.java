import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import io.restassured.RestAssured;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RestUtil{
    private final Logger LOGGER = LogManager.getLogger(RestUtil.class);
    public ObjectMapper mapper = new ObjectMapper();
    private String token;

    public RequestSpecification given(String uri){
        RestAssured.baseURI = uri;
        LOGGER.info("the baseURI is "+uri);
        RequestSpecification request = RestAssured.given();
        return request;
    }
    public void addPayloadFile(RequestSpecification req, File file){
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JsonNode json=null;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String readFile="";
            String line = reader.readLine();
            while(line!=null){
                readFile+=line;
            }
            req.given().body(readFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void createProgram(String name){
        JSONObject json = new JSONObject();
        json.put("name",name);
        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .post("program");
        LOGGER.info(res.then().log().all());
    }
    public void getProgramSource(String token){
        Response res = RestAssured.given().get("program/"+token);
        LOGGER.info(res.then().log().all());

    }

}