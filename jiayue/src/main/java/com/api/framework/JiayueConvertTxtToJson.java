package com.api.framework;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JiayueConvertTxtToJson {
    @SuppressWarnings("unchecked")
    public static void convert(String inputDir) throws Exception{

        try (BufferedReader reader = new BufferedReader(new FileReader(inputDir))) {
            JSONArray personList = new JSONArray();
            String line = reader.readLine();
            String[] dataName = line.split("\\s+");
            String[] data;
            line = reader.readLine();

            while(line != null) {
                JSONObject person = new JSONObject();
                data = line.split("\\s+");
                for (int i = 0; i < dataName.length; i++) {
                    if (data[i].contains(",")) {
                        String[] items = data[i].split(",");
                        JSONArray inner = new JSONArray();
                        for (int j = 0; j < items.length; j++) {
                            inner.add(items[j]);
                        }
                        person.put(dataName[i], inner);

                    }

                    else {
                        person.put(dataName[i], data[i]);
                    }
                }

                personList.add(person);
                line = reader.readLine();
            }


            try (FileWriter file = new FileWriter("jiayueOutput.json")) {

                file.write(personList.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public static void main(String[] arr) throws Exception {
        convert("src/main/resources/jiayueInputText");
    }
}