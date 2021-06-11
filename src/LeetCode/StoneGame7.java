package LeetCode;

import java.util.Arrays;

public class StoneGame7 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4};
        System.out.println(stoneGameVII(arr));

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] dp;

    public static int stoneGameVII(int[] stones) {
        int n = stones.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int sum = 0;
        for (int stone : stones) {
            sum = sum + stone;
        }
        return stoneGame(0, stones.length - 1, stones, sum);
    }

    private static int stoneGame(int l, int r, int[] stones, int sum) {
        if (l == r){
            return dp[l][r] = 0;
        }

        if (dp[l][r] != -1)
            return dp[l][r];
        int ans1 = sum - stones[r] - stoneGame(l, r - 1, stones, sum - stones[r]);
        int ans2 = sum - stones[l] - stoneGame(l + 1, r, stones, sum - stones[l]);
        return dp[l][r] = Math.max(ans1, ans2);
    }


    //    public static int stoneGame(int[] arr) {
//        int n = arr.length;
//        int sum = 0;
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            sum += arr[i];
//        }
//        int start = 0;
//        int end = n - 1;
//        int alice = 0;
//        int bob = 0;
//        for (int i = 0; i < n; i++) {
//            if (i % 2 == 0) {
//                if(arr[start] >)
//                int min = Math.min(arr[start], arr[end]);
//                sum = sum - min;
//                alice = alice + sum;
//            } else {
//
//            }
//        }
//        return alice - bob;
//    }
}
