package txtToJson;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TxtToJson {

    public static void txtToJSON(String txtPath) throws IOException {
        // Read txt file
        ObjectMapper mapper = new ObjectMapper();

        Path path = Paths.get(txtPath);

        // Write data to JSON file

        String str = new String(Files.readAllBytes(path));

        Files.write(Paths.get("thanhquan\\src\\main\\resources\\output.json"), mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(mapper.readTree(str)));
        System.out.println("Output from json file: ");
        System.out.println(str);

    }
    public static void main(String[] args) throws IOException {
        String txtToJSON = "thanhquan\\src\\main\\resources\\data.txt";
        txtToJSON(txtToJSON);
    }
}
