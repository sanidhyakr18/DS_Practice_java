package LeetCode;

import java.util.Arrays;
import java.util.Collections;

public class MatchsticksSquare {
    public static void main(String[] args) {
        int[] matchsticks = new int[]{5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4};
//        count = 0;
        System.out.println(makesquare(matchsticks));
//        System.out.println(count);
    }

    public static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) {
            sum = sum + i;
        }
        if (sum % 4 != 0)
            return false;
        else {
            Arrays.sort(matchsticks);
            int i = matchsticks.length - 1;
            return checkSquare(matchsticks, 0, 0, 0, 0, i, sum / 4);
        }

    }
//    public static long count;
    private static boolean checkSquare(int[] arr, long s1, long s2, long s3, long s4, int i, long sum) {
//        count++;
        if (i == -1) {
            return s1 == s2 && s1 == s3 && s3 == s4;
        }
        if (s1 > sum || s2 > sum || s3 > sum || s4 > sum) {
            return false;
        }
        return checkSquare(arr, s1 + arr[i], s2, s3, s4, i - 1, sum) ||
                checkSquare(arr, s1, s2 + arr[i], s3, s4, i - 1, sum) ||
                checkSquare(arr, s1, s2, s3 + arr[i], s4, i - 1, sum) ||
                checkSquare(arr, s1, s2, s3, s4 + arr[i], i - 1, sum);
    }
}
