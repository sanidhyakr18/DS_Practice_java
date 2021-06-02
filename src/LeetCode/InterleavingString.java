package LeetCode;

import java.util.Arrays;

public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    //    using iteration with dp
    public static boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        if (c1.length + c2.length - c3.length != 0) return false;

        boolean[][] dp = new boolean[c1.length + 1][c2.length + 1];

        dp[0][0] = true;

        for (int i = 0; i <= c1.length; i++) {
            for (int j = 0; j <= c2.length; j++) {
                int k = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (c1[i - 1] == c3[k] && dp[i - 1][j]);
                }

                if (j > 0) {
                    dp[i][j] = dp[i][j] || (c2[j - 1] == c3[k] && dp[i][j - 1]);
                }
            }
        }

        return dp[c1.length][c2.length];
    }

//    using iteration without dp
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        int curr1 = 0;
//        int curr2 = 0;
//        for (int i = 0; i < s3.length(); i++) {
//            System.out.print(s3.charAt(i) + " ");
//            if (curr1 < s1.length() && s1.charAt(curr1) == s3.charAt(i)) {
//                System.out.print(s1.charAt(curr1) + " " + "S1");
//                curr1++;
//            } else if (curr2 < s2.length() && s2.charAt(curr2) == s3.charAt(i)) {
//                System.out.print(s2.charAt(curr2) + " " + "S2");
//                curr2++;
//            } else {
//                return false;
//            }
//            System.out.println();
//        }
//        return true;
//    }

//    using recursion without dp
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length() + s2.length() != s3.length())
//            return false;
//
//        if (s3.length() == 0) {
//            return s1.length() == 0 && s2.length() == 0;
//        } else {
//            if (s1.length() == 0 && s2.length() == 0)
//                return false;
//        }
//
//        if (s1.length() == 0) {
//            if (s2.charAt(0) == s3.charAt(0)) {
//                return isInterleave(s1, s2.substring(1), s3.substring(1));
//            } else {
//                return false;
//            }
//        }
//
//        if (s2.length() == 0) {
//            if (s1.charAt(0) == s3.charAt(0)) {
//                return isInterleave(s1.substring(1), s2, s3.substring(1));
//            } else {
//                return false;
//            }
//        }
//
//        if (s1.charAt(0) == s2.charAt(0) && s1.charAt(0) == s3.charAt(0)) {
//            if (isInterleave(s1.substring(1), s2, s3.substring(1)))
//                return true;
//            else return isInterleave(s1, s2.substring(1), s3.substring(1));
//        } else if (s1.charAt(0) == s3.charAt(0)) {
//            return isInterleave(s1.substring(1), s2, s3.substring(1));
//        } else if (s2.charAt(0) == s3.charAt(0)) {
//            return isInterleave(s1, s2.substring(1), s3.substring(1));
//        } else {
//            return false;
//        }
//    }
}