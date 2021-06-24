package LeetCode;

import java.util.HashSet;

public class ArithProgSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3};
        System.out.println(canMakeArithmeticProgression(arr));
    }

//    O(NlogN) Solution
//    public static boolean canMakeArithmeticProgression(int[] arr) {
//        Arrays.sort(arr);
//        int diff = arr[1] - arr[0];
//        for (int i = 2; i < arr.length; i++) {
//            if (arr[i] - arr[i - 1] != diff)
//                return false;
//        }
//        return true;
//    }

//    O(N) Solution
    public static boolean canMakeArithmeticProgression(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            set.add(j);
            max = Math.max(max, j);
            min = Math.min(min, j);
        }
        int diff = (max - min) / (arr.length - 1);
        for (int i = 1; i < arr.length; i++) {
            if (!set.contains(min + i * diff)) {
                return false;
            }
        }
        return true;
    }
}
