import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class AlexTxtToJson {

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

    public static void writeToJsonPretty(String fileName){
        //Create new File if file does not exist
        try{
            File file = new File("data.json");
            if(file.exists()) {
                file.delete();
            }
            file.createNewFile();

            //Convert String into PrettyStringJson
            ObjectMapper mapper = new ObjectMapper();
            Object jsonObject = mapper.readValue(fileName, Object.class);
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);

            //Write String into JSON file
            Writer write = new OutputStreamWriter(new FileOutputStream(file));
            write.write(prettyJson);

            write.flush();
            write.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String textFile = readFile("C:\\Users\\Vuong\\IdeaProjects\\varamini\\src\\main\\resources\\AlexInputText");
        writeToJsonPretty(textFile);
    }
}