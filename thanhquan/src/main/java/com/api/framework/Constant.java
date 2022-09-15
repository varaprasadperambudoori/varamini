package com.api.framework;

public class Constant {


    // Constant for Request Builder Modify Data
    public static String HEADER = "HEADER";
    public static String BODY = "BODY";
    public static String QUERY = "QUERY";

    // Constant for Request Type
    public static String POST = "POST";
    public static String GET = "GET";

    // Credentials
    public static String username = "c598a04a-5c04-4dad-a5b5-d5dfc66e5feb";
    public static String password = "5f791fce-154f-4d7f-ba7a-a4b44212a146";

    // Endpoints
    public static String create_user  ="/users";
    public static String get_all_users  ="/users";
    public static String get_single_user  ="/users/?first_name={first_name}";
}
