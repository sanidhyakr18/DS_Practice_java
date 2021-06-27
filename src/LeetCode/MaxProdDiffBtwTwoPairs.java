package LeetCode;

import java.util.PriorityQueue;
import java.util.Stack;

public class MaxProdDiffBtwTwoPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 5, 9, 7, 4, 8};
        System.out.println(maxProductDifference(nums));
    }

    public static int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 -o1);
        PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 -o2);
        for (int i = 0; i < nums.length; i++) {
            max.add(nums[i]);
            min.add(nums[i]);
        }
        return max.poll() * max.poll() - min.poll() * min.poll();
    }

//    public static int maxProductDifference(int[] nums) {
//        int max1 = 0;
//        int max2 = 0;
//        int min1 = 10005;
//        int min2 = 10005;
//        Stack<Integer> max = new Stack<>();
//        Stack<Integer> min = new Stack<>();
//        max.push(0);
//        min.push(10005);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max.peek()) {
////                max2 = max1;
////                max1 = nums[i];
//                max.push(nums[i]);
//                System.out.println(nums[i]);
//            }
//            if (nums[i] < min.peek()) {
////                min2 = min1;
////                min1 = nums[i];
//                min.push(nums[i]);
//                System.out.println(nums[i]);
//            }
////            System.out.println(max1 + " " + max2 + " " + min1 + " " + min2);
//        }
//        return max.pop() * max.pop() - min.pop() * min.pop();
//    }

}
