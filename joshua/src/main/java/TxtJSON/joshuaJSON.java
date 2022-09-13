package TxtJSON;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;



public class joshuaJSON {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        JsonParser pars = new JsonParser();

        try {
            JsonObject jo = (JsonObject) pars.parse(new FileReader("joshua/src/main/resources/joshuaTxtFileToJSONFile.txt"));

            FileWriter file = new FileWriter("joshua/src/main/resources/joshuaTestJSONfile.json");
            file.write(jo.toString());
            file.close();
            System.out.println(jo.toString());
        }
        catch(Exception e) {
            e.printStackTrace();
        }


    }

}

