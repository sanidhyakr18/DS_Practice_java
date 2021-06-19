package LeetCode;

import java.util.Arrays;

public class KInversePairsArray {
    public static void main(String[] args) {
        int n = 1000;
        int k = 1000;
        System.out.println(kInversePairs(n, k));
    }

    public static int kInversePairs(int n, int k) {
        int[][] dp = new int[1001][1001];

        int mod = 1000000007;
//        dp[1][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int val = (dp[i - 1][j] + mod - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % mod;
                    dp[i][j] = (dp[i][j - 1] + val) % mod;
                }
            }
        }
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= k; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        return  ((dp[n][k] + mod - (k > 0 ? dp[n][k - 1] : 0)) % mod);
    }
}