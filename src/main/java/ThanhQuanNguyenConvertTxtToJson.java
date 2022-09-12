import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void txtToJSON(String txtPath) throws IOException {
    	// Read txt file
    	ObjectMapper mapper = new ObjectMapper();

    	Path path = Paths.get(txtPath);
    	
    	// Write data to JSON file
    	
    	String str = new String(Files.readAllBytes(path));
    	
    	Files.write(Paths.get("src/main/java/part1_txtToJson/output.json"), mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(mapper.readTree(str)));
	}
	
    public static void main(String[] args) throws IOException, ParseException 
    {
    	String txtToJSON = "src/main/java/part1_txtToJson/data.txt";
    	txtToJSON(txtToJSON);
    	
    }

}
