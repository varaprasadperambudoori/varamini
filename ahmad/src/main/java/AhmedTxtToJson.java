import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.io.FileOutputStream;

public class AhmedTxtToJson {
    public static void main(String[] a) {
        String text;
        try {
            text = new String(Files.readAllBytes(Paths.get("convertToJson.src/main/resources/AhmedInputText")));
            File json = new File("convertToJson.src/main/resources/AhmedOutputText.json");
            Writer write = new OutputStreamWriter(new FileOutputStream(json));
            write.write(text);
            write.flush();
            write.close();
            System.out.println(text);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}