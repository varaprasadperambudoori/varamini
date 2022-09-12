import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JoshuaJSON {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JsonParser pars = new JsonParser();

		try {
			JsonObject jo = (JsonObject) pars.parse(new FileReader("/Users/Joshua/Desktop/WORK/JSON_files/test.txt"));
			
			FileWriter file = new FileWriter("testJSONfile.json");
			file.write(jo.toString());
			file.close();
			System.out.println(jo.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
