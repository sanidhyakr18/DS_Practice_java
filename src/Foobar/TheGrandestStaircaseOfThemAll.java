package Foobar;

public class TheGrandestStaircaseOfThemAll {

    public static int[][] dp = new int[201][201];

    public static void main(String[] args) {
        fillMatrix();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        fillMatrix();
        return dp[n][n] - 1;
    }

    public static void fillMatrix() {
        dp[1][1] = 1;
        dp[2][2] = 1;
        for (int i = 3; i < 201; i++) {
            for (int j = 1; j <= i; j++) {
                if (i - j == 0) {
                    dp[i][j] = 1 + dp[i][j - 1];
                } else if (i - j < j) {

                    dp[i][j] = dp[i - j][i - j] + dp[i][j - 1];

                } else if (i - j == j) {
                    dp[i][j] = dp[j][j - 1] + dp[i][j - 1];

                } else if (i - j > j) {

                    dp[i][j] = dp[i - j][j - 1] + dp[i][j - 1];
                }
            }
        }
    }
}
