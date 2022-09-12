import java.util.ArrayList;
import java.util.List;

public class ParentheseCombination {
    public static List<String> getCombination(int n) {
        List<String> ans = new ArrayList<>();
        backtrace(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    public static void backtrace(int n, int open, int close, StringBuilder comb, List<String> combs) {
        if(open == n && close == n) {
            combs.add(comb.toString());
            return;
        }

        if(open < n) {
            comb.append("(");
            backtrace(n, open + 1, close, comb, combs);
            comb.deleteCharAt(comb.length() - 1);
        }
        if(open > close) {
            comb.append(")");
            backtrace(n, open, close + 1, comb, combs);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
