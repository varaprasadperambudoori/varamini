package com.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import static com.api.Constants.*;

public class ProgramSource {
    RestUtil rest;
    String token;
    public ProgramSource(){
        rest = new RestUtil();
        rest.login(DEFAULT_USER,DEFAULT_PASSWORD).given();
    }
    public void createProgram(String name){
        JSONObject json = new JSONObject();
        json.put("name",name);
        token = rest.addPayLoad(json).postRequest(CREATE_PROGRAMSOURCE).path("token");
    }
    public void getProgramSource(String token){
        rest.getRequest(GET_UPDATE_PROGRAMSOURCE+token);
    }
}
