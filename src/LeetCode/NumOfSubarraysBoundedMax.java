package LeetCode;

import java.util.ArrayList;

public class NumOfSubarraysBoundedMax {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4, 3};
        int left = 2;
        int right = 3;
        System.out.println(numSubarrayBoundedMax(nums, left, right));
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[j], max);
                if (max >= left && max <= right)
                    ans++;
                else if (max > right)
                    break;
            }
        }
        return ans;
    }
}
