package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generate(n));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < i - 1; j++) {
                int sum = list.get(i - 1).get(j) + list.get(i - 1).get(j + 1);
                temp.add(sum);
            }
            if (i != 0) temp.add(1);
            list.add(temp);
        }
        return list;
    }
}
