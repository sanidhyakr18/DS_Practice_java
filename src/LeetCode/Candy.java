package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,1,2,1,2,2,2,2,1,0,1,1,2,1,1,2,2};
//        int[] arr = new int[]{1, 2, 2};
        System.out.println(candy(arr));
    }

    public static int candy(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        if (arr.length == 2) {
            if (arr[0] == arr[1]) return 2;
            else return 3;
        }

        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        ArrayList<Integer> max = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] > arr[i + 1]) {
                    max.add(i);
                }

            } else if (i == arr.length - 1) {
                if (arr[i] > arr[i - 1]) {
                    max.add(i);
                }
            } else {
                if (arr[i] > arr[i + 1] && arr[i] >= arr[i - 1] || arr[i] >= arr[i + 1] && arr[i] > arr[i - 1]) {
                    max.add(i);
                }
            }
        }
//        System.out.println(max);
        for (int i = 0; i < max.size(); i++) {
            int countRight = 0;
            int j = max.get(i);
            int indexRight = j + 1;
            while (indexRight < arr.length) {
                if (arr[indexRight] < arr[indexRight - 1]) {
                    countRight++;
                } else {
                    break;
                }
                indexRight++;
            }

            int countLeft = 0;
            int indexLeft = j - 1;
            while (indexLeft >= 0) {
                if (arr[indexLeft] < arr[indexLeft + 1]) {
                    countLeft++;
                } else {
                    break;
                }
                indexLeft--;
            }

            dp[j] = Math.max(countLeft, countRight) + 1;

            for (int k = j - countLeft; k < j; k++) {
                dp[k] = k == j - countLeft ? 1 : dp[k - 1] + 1;
            }
            for (int k = j + countRight; k > j; k--) {
                dp[k] = k == j + countRight ? 1 : dp[k + 1] + 1;
            }

        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
            sum = sum + dp[i];
        }
//        System.out.println();
        return sum;
    }
}
