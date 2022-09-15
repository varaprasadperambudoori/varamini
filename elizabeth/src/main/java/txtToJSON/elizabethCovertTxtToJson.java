package txtToJSON;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class elizabethCovertTxtToJson {
    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();

        File fileTXT = new File("elizabeth/src/main/resources/elizabethInputTxt.txt");

        try {
            JSONObject object = (JSONObject) jsonParser.parse(new FileReader(fileTXT));

            System.out.println(object.toString());

            File fileJSON = new File("elizabeth/src/main/resources/elizabethOutput.json");

            FileWriter output = new FileWriter(fileJSON);

            System.out.println(fileJSON.exists());

            output.append(object.toString());
            output.close();

            File result = new File("elizabeth/src/main/resources/elizabethOutput.json");

            Scanner read = new Scanner(result);
            System.out.println("Output from the json File");
            while(read.hasNextLine()) {

                System.out.println(read.nextLine());
            }

        }catch(Exception e) {

        }

    }
}
