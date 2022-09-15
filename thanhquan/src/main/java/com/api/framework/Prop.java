package com.api.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Prop {

    Properties prop =new Properties();
    FileInputStream file;
    {
        try
        {
            file = new FileInputStream("./src/main/resources/config.properties");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}