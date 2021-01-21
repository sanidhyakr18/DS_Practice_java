package Foobar;

import java.util.ArrayList;

public class FindTheAccessCodes {
    public static void main(String[] args) {
//        for (int i = 0; i < size - 2; i++) {
//            for (int j = i + 1; j < size - 1; j++) {
//                for (int k = j + 1; k < size; k++) {
//                    count++;
//                }
//            }
//        }
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 12}));
    }

    public static int solution(int[] l) {
        int count = 0;
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            dp.add(new ArrayList<>());
            for (int j = i + 1; j < l.length; j++) {
                if (l[j] % l[i] == 0) {
                    dp.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < dp.size() - 2; i++) {
            for (int j = 0; j < dp.get(i).size(); j++) {
                int index = dp.get(i).get(j);
                count += dp.get(index).size();
            }
        }
        return count;
    }

//    public static int solution(int[] l) {
//        int count = 0;
//        int size = l.length;
////        int[][] dp = new int[size-1][size-1];
//        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
//        for (int i = 0; i < l.length; i++) {
////            int index = 0;
//            dp.add(new ArrayList<>());
//            for (int j = i + 1; j < l.length; j++) {
//                if (l[j] % l[i] == 0) {
////                    dp[i][index] = j;
//                    dp.get(i).add(j);
////                    index++;
//                }
//            }
//        }
////        for (int i = 0; i < dp.size(); i++) {
////            for (int j = 0; j < dp.get(i).size(); j++) {
////                System.out.print(dp.get(i).get(j) + " ");
////            }
////            System.out.println(dp.get(i).size());
////        }
//        for (int i = 0; i < dp.size() - 2; i++) {
//            for (int j = 0; j < dp.get(i).size(); j++) {
//                int index = dp.get(i).get(j);
//                count += dp.get(index).size();
//            }
//        }
//        return count;
//    }
}
