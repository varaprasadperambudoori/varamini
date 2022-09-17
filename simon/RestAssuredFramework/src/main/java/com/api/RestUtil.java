package com.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
import java.lang.reflect.Field;

import static com.api.Constants.*;
import static com.api.JsonToPojo.*;
public class RestUtil{
    private static final Logger LOGGER = LogManager.getLogger(RestUtil.class);
    public ObjectMapper mapper = new ObjectMapper();
    private String token;
    public RequestSpecification request;
    public Response response;
    private String username,password;

    public RestUtil(){
    }
    public void given(){
        RestAssured.baseURI = BASEURI;
        LOGGER.info("the baseURI is "+RestAssured.baseURI);
        request = RestAssured.given().auth().basic(username,password);
    }
    public RestUtil login(String user,String pass){
        this.username = user;
        this.password = pass;
        return this;
    }
    public  void logout(){
        this.username = "";
        this.password="";
    }

    public void addPayload(File file){
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //JsonNode json=null;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String readFile="";
            String line = reader.readLine();
            while(line!=null){
                readFile+=line;
            }
            request.body(readFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public RestUtil addPayLoad(JSONObject json,String endpoint){
        request.contentType(ContentType.JSON).body(json.toString());
        makePojo(findVariableName(endpoint).toLowerCase(),json,"Req");
        return this;
    }
    public Response postRequest(String endpoint){
        response = request.post(endpoint);
        JSONObject resJson = new JSONObject(response.body().asString());
        makePojo(findVariableName(endpoint).toLowerCase(),resJson,"Res");

        LOGGER.info("Status Code: "+response.getStatusCode()+"\nPayload: "+response.getBody().prettyPrint());
        return  response;
    }
    public void getRequest(String endpoint){
        response = request.get(endpoint);
        JSONObject json = new JSONObject(response.body().asString());
        makePojo(findVariableName(endpoint).toLowerCase(),json,"Res");
        LOGGER.info("Status Code: "+response.getStatusCode()+"\nPayload: "+response.getBody().prettyPrint());

    }
    public String findVariableName(String value){
        String name="";
        for(Field fieldName: Constants.class.getDeclaredFields()){
            try{
                if(fieldName.get(this).equals(value)){
                    name = fieldName.getName();
                }

            }catch (Exception e ){
                e.printStackTrace();
            }
        }
        return name;
    }
    public void makePojo(String endpointName, JSONObject json,String resreq){
        File file = new File(POJO_SOURCE +POJO_FOLDER+"/"+endpointName+resreq+"Pojo.java");
        System.out.println(POJO_SOURCE+POJO_FOLDER+endpointName+"Pojo.java");
        if(!file.exists()){
            System.out.println("file doesn't exist");
            convertFromJsonObj(json,
                    new File(POJO_SOURCE),
                    POJO_FOLDER.replace("/","."),
                    endpointName+resreq+"Pojo");
            LOGGER.info("Created Pojo for Create Program Source");
        }else{
            LOGGER.info("Pojo found.");
            System.out.println("Found the file!");
        }
    }

}