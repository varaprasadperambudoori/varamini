package com.api;

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
        token = rest.addPayLoad(json,CREATEPROGRAMSOURCE).postRequest(CREATEPROGRAMSOURCE).path("token");
    }
    public void getProgramSource(String token){
        rest.getRequest(GETPROGRAMSOURCE +token);
    }
}
