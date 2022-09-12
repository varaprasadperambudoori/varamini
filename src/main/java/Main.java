import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonConverter.convert("jsonData2.txt");
        List<String> li = ParentheseCombination.getCombination(3);
        System.out.println(li);
    }
}
