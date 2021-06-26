package LeetCode;

public class MaxAlternatingSum {
    public static void main(String[] args) {
        int[] arr = new int[] {6,2,1,2,4,5};
        System.out.println(maxAlternatingSum(arr));
    }

    public static long maxAlternatingSum(int[] nums) {
        long sum = 0;
        long curr = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length-1; i++) {
            if(flag) {
                if(nums[i+1] >= nums[i])
                    continue;
                else {
                    curr = curr + nums[i];
                    flag = false;
                }
            } else {
                if(nums[i+1] <= nums[i])
                    continue;
                else {
                    curr = curr - nums[i];
                    flag = true;
                }
            }
            sum = Math.max(sum, curr);
        }
        if(flag) {
            curr = curr + nums[nums.length-1];
        } else {
            curr = curr - nums[nums.length-1];
        }
        sum = Math.max(sum, curr);
        return sum;
    }
}
