package com.api.pojo;

import com.api.framework.RestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import convertToJson.JsonConverter;

public class PojoUtil {
    public static String getJsonFromUser(User user){
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = "";
        try {
            userJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userJson;
    }

    public static User getUserFromJson(String jsonData) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        try {
            user = objectMapper.readValue(jsonData, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
