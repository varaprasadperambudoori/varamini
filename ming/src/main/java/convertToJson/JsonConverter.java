package convertToJson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JsonConverter {

    private static String readFromTxt(String path) {
        String result = "";
        File file = new File(path);
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(isr);
            String lineText = null;
            while((lineText = br.readLine()) != null) {
                result += lineText;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        result = result.replaceAll(" ","");
        result = result.replaceAll("\t", "");
        return result;
    }

    private static String readFromXlsx(String path) {
        StringBuilder result = new StringBuilder();

        try {
            InputStream is = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet("Sheet1");
            Row row = sheet.getRow(0);
            List<String> attributes = new ArrayList<>();
            DataFormatter fmt = new DataFormatter();
            for(int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                attributes.add(fmt.formatCellValue(row.getCell(i)));
            }

            result.append("[");
            result.append("\n");
            for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                result.append(indent(1));
                result.append("{");
                result.append("\n");
                for(int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    result.append(indent(2));
                    result.append("\"" + attributes.get(i) + "\"" + ":" + "\"" + fmt.formatCellValue(sheet.getRow(i).getCell(j)) + "\"");
                    if(j < row.getPhysicalNumberOfCells() - 1) {
                        result.append(",");
                    }
                    result.append("\n");
                }
                result.append(indent(1));
                result.append("}");
                if(i < sheet.getPhysicalNumberOfRows() - 1) {
                    result.append(",");
                }
                result.append("\n");
            }
            result.append("]");

        }catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    private static String formatJson(String json) {
        StringBuffer result = new StringBuffer();
        int length = json.length();
        int number = 0;
        char key = 0;

        for(int i = 0; i < length; i++) {
            key = json.charAt(i);

            if((key == '[') || (key == '{')) {
                result.append(key);
                result.append('\n');
                number++;
                result.append(indent(number));
                continue;
            }

            if((key == ']') || (key == '}')) {
                result.append('\n');
                number--;
                result.append(indent(number));
                result.append(key);
                continue;
            }

            if(key == ',') {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }
            result.append(key);

        }
        return result.toString();
    }

    private static void writeToJson(String json) {
        try {
            File file = new File("ming/data.json");
            if(file.exists()) {
                file.delete();
            }
            file.createNewFile();

            Writer write = new OutputStreamWriter(new FileOutputStream(file));
            write.write(json);
            write.flush();
            write.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void convert(String path) {
        boolean isTxt = true;
        String step2 = "";
        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == '.') {
                if(path.charAt(i + 1) == 'x') {
                    isTxt = false;
                }
                break;
            }
        }
        if(isTxt) {
            String step1 = readFromTxt(path);
            step2 = formatJson(step1);
        }else {
            step2 = readFromXlsx(path);
        }

        writeToJson(step2);
    }

    private static String indent(int number) {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < number; i++) {
            result.append("    ");
        }
        return result.toString();
    }
}
