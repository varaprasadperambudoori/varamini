package driverz;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.codehaus.jackson.map.ObjectMapper;


public class convertToJson {

    public static void main(String a[]){

        try {
            File jsonInputFile = new File("/Users/simrahhussain/IdeaProjects/convertingJsonNisum/src/main/textToJson.txt");
            ObjectMapper mapper = new ObjectMapper();
            driversCarsPOJO dc = mapper.readValue(jsonInputFile, driversCarsPOJO.class);
            mapper.writeValue(Paths.get("txtToJson.json").toFile(), dc);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
