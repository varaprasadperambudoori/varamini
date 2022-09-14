import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;

public class AlexTextToJson {

    public static String readFile(String fileName){
        String result = "";
        File file = new File(fileName);
        try{
            FileReader in = new FileReader(fileName);
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String writeToJsonPretty(String fileName) {
        //Create new File if file does not exist
        String prettyJson = null;
        try {
            File file = new File("alex/src/main/resources/jsonData.json");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            //Convert String into PrettyStringJson
            ObjectMapper mapper = new ObjectMapper();
            Object jsonObject = mapper.readValue(fileName, Object.class);
            prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);

            //Write String into JSON file
            Writer write = new OutputStreamWriter(new FileOutputStream(file));
            write.write(prettyJson);

            write.flush();
            write.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prettyJson;
    }

    public static void main(String[] args) throws IOException {
        String textFile = readFile("alex/src/main/resources/AlexInputText");
        System.out.println(writeToJsonPretty(textFile));
    }
}