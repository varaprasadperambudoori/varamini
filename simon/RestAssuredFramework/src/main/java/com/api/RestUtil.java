package com.api;

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
import static com.api.Constants.*;
public class RestUtil{
    private final Logger LOGGER = LogManager.getLogger(RestUtil.class);
    public ObjectMapper mapper = new ObjectMapper();
    private String token;
    private RequestSpecification request;
    private String username,password;

    public RestUtil given(){
        RestAssured.baseURI = BASEURI;
        LOGGER.info("the baseURI is "+RestAssured.baseURI);
        request = RestAssured.given().auth().basic(username,password);
        return this;
    }
    public void login(String user,String pass){
        this.username = user;
        this.password = pass;
    }
    public  void logout(){
        this.username = "";
        this.password="";
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
        Response res = request.contentType(ContentType.JSON)
                .post(CREATE_PROGRAMSOURCE);
        //TODO set token

        LOGGER.info(res.getBody().prettyPrint());
    }
    public void getProgramSource(String token){
        Response res = request.get(GET_UPDATE_PROGRAMSOURCE+token);
        LOGGER.info(res.getBody().prettyPrint());
    }
    public void createUser(String firstName,String lastName, String status,String email,String phoneNum){
        JSONObject json = new JSONObject();
        json.put("first_name",firstName);
        json.put("last_name",lastName);
        json.put("active",status);
        json.put("email",email);
        json.put("phone",phoneNum);
        Response res = request.body(json.toString()).post(CREATE_USER);
        LOGGER.info("Status Code: "+res.getStatusCode()+"\nPayload: "+res.getBody().prettyPrint());
    }
}