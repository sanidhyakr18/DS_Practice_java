package LeetCode;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        int m = 8;
        int n = 50;
        int maxMove = 23;
        int startRow = 5;
        int startColumn = 26;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public static int[][][] dp;

    public static int findPaths(int m, int n, int maxMove, int i, int j) {
        dp = new int[m + 1][n + 1][maxMove + 1];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return findPathsRec(m, n, maxMove, i, j) % 1000000007;
    }

    private static int findPathsRec(int m, int n, int maxMove, int i, int j) {
//        System.out.println(i + " " + j);
//        if (((i == 0 && j == 0) || (i == 0 && j == n - 1)
//                || (i == m - 1 && j == n - 1) || (i == m - 1 && j == 0)) && maxMove >= 1)
//            return 2;
//        if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && maxMove >= 1)
//            return 1;

        if ((i == -1 || j == -1 || i == m || j == n) && maxMove >= 0)
            return 1;

        if (maxMove < 0)
            return 0;

        if (dp[i][j][maxMove] != -1) {
            return dp[i][j][maxMove];
        }

        long totalWays = 0;
        totalWays += findPathsRec(m, n, maxMove - 1, i, j + 1) % 1000000007;
        totalWays += findPathsRec(m, n, maxMove - 1, i + 1, j) % 1000000007;
        totalWays += findPathsRec(m, n, maxMove - 1, i, j - 1) % 1000000007;
        totalWays += findPathsRec(m, n, maxMove - 1, i - 1, j) % 1000000007;

        return dp[i][j][maxMove] = (int) (totalWays % 1000000007);
    }
}
