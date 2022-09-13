import com.sun.codemodel.JCodeModel;
import org.json.JSONObject;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;


public class SimonTxtToJson {
    public static void convertToJson(String filename){
        JSONObject json;
        StringBuilder jsonTxtFile;
        try {
            BufferedReader buff = new BufferedReader(new FileReader(filename));
            String line = buff.readLine();
            //System.out.println(line);
            jsonTxtFile = new StringBuilder();
            do {
                jsonTxtFile.append(line);
                jsonTxtFile.append("\n");
                line = buff.readLine();
                //System.out.println(line);
            } while (line!=null);
            //System.out.println("txt file read: \n"+jsonTxtFile);
            json = new JSONObject(jsonTxtFile.toString());
            System.out.println("jsonobject:\n"+json);
            FileWriter writer = new FileWriter("src/main/resources/newFile.json");
            writer.write(json.toString());
            writer.flush();
            buff.close();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void  countParentheses(int max, String s, ArrayList<String> print){
        if(max == 1){
            print.add("()");
            return;
        }
        int countOpenParentheses = (int) s.chars().filter(ch -> ch=='(').count();
        int countCloseParentheses = (int) s.chars().filter(ch->ch==(')')).count();
        if(countOpenParentheses == max && countCloseParentheses == max){
            print.add(s);
            return;
        }
        if(countOpenParentheses < max){
            countParentheses(max,s+"(",print);
        }
        if(countCloseParentheses < countOpenParentheses){
            countParentheses(max,s+")",print);

        }
    }
    public static void convertJsonToJava(URL jsonURL, File outputDirectory, String packageName, String className){
        try{
            JCodeModel model = new JCodeModel();
            GenerationConfig config = new DefaultGenerationConfig(){
                @Override
                public boolean isGenerateBuilders(){
                    return true;
                }
                @Override
                public SourceType getSourceType(){
                    return SourceType.JSON;
                }
            };
            SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config),
                    new SchemaStore()),
                    new SchemaGenerator());

            mapper.generate(model,className,packageName,jsonURL);
            model.build(outputDirectory);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ArrayList<String> answer = new ArrayList<>();
        String packageName="com.jsonclass";

        File inputJson = new File("src/main/resources/newFile.json");
        File outputDirectory = new File("."+File.separator+"convertedPojo");
        outputDirectory.mkdirs();
        String className =inputJson.getName().replace(".json","");
        convertToJson("src/main/resources/file.txt");
        /*countParentheses(3,"",answer);
        for(String str:answer){
            System.out.println(str);
        }
        try{
            new SimonTxtToJson().convertJsonToJava(inputJson.toURI().toURL(),outputDirectory,packageName,className);
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
