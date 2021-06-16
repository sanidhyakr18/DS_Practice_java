package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n =3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> list;

    public static List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        generateCombinations(n, 0, 0, 0, "");
        return list;
    }

    private static  void generateCombinations(int n, int count, int open, int close, String str) {
        if (count == 2 * n) {
            list.add(str);
            return;
        }
        String myStr;
        if (open < n) {
            myStr = str + "(";
            generateCombinations(n, count + 1, open + 1, close, myStr);
        }
        if (close < open) {
            myStr = str + ")";
            generateCombinations(n, count + 1, open, close + 1, myStr);
        }
    }
}
