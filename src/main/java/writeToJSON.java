import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class writeToJSON {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JsonParser pars = new JsonParser();

		try {
			JsonObject jo = (JsonObject) pars.parse(new FileReader("C:\\Users\\Joshua\\Desktop\\WORK\\java_assignment\\varamini\\src\\main\\resources\\writeToJSON.txt"));
			
			FileWriter file = new FileWriter("testJSONfile.json");
			file.write(jo.toString());
			file.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
