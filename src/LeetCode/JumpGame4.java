package LeetCode;

import java.util.PriorityQueue;

public class JumpGame4 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, -2, 4, -7, 3};
        int k = 3;
//        int[] nums = new int[] {10,-5,-2,4,0,3};
//        int k = 3;
//        int[] nums = new int[]{1, -5, -20, 4, -1, 3, -6, -3};
//        int k = 2;

        System.out.println(maxResult(nums, k));
//        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        p.add(10);
//        p.add(20);
//        p.add(40);
//        p.add(35);
//        p.add(25);
//        p.add(30);
//        p.add(15);
//        p.add(12);
//
//        System.out.println(p);
//        p.remove(25);
//
//        System.out.println(p);
//        p.add(20);
//        System.out.println(p);
//        p.remove(40);
//        p.add(405);
//        System.out.println(p);
    }

//    private static int maxResult(int[] nums, int k) {
////        int[] dp = new int[nums.length];
//        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
//        pq.add(new int[]{nums[0], 0});
//        for (int i = 1; i < nums.length; i++) {
//            if (!pq.isEmpty()) {
////                if (pq.size() < k) {
////                    nums[i] += pq.top().first;
//                nums[i] += pq.peek()[0];
//                pq.add(new int[]{nums[i], i});
////                    nums[i] = Math.max(nums[i], nums[i] + pq.peek());
////                } else {
//                if (i - k >= 0) {
//                    while (pq.peek()[1] <= i - k)
//                        pq.poll();
//                }
//
////                }
//            }
//        }
//        return nums[nums.length - 1];
//    }

    public static int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        pq.add(new int[]{nums[0], 0});
        for (int i = 1; i < nums.length; i++) {
            if (!pq.isEmpty()) {
                nums[i] = nums[i] + pq.peek()[0];
                pq.add(new int[]{nums[i], i});
                if (i >= k) {
                    while (pq.peek()[1] <= i - k)
                        pq.poll();
                }
            }
        }
        return nums[nums.length - 1];
    }
}