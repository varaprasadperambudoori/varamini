import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.io.FileOutputStream;

public class AhmedTxtToJson {
    public static void main(String[] a) {
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get("C:\\Users\\Ahmed\\Desktop\\GitHubTraining\\varamini\\src\\main\\resources\\jeeshanInputText")));
            File json = new File("C:\\Users\\Ahmed\\Desktop\\GitHubTraining\\output.json");
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