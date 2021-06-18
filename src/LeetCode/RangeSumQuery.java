package LeetCode;

import java.util.Arrays;

public class RangeSumQuery {
    public static void main(String[] args) {
        int[] nums = new int[] {-28,-39,53,65,11,-56,-65,-39,-43,97};
        NumArray obj = new NumArray(nums);
        obj.update(0, 2);
        System.out.println(obj.sumRange(1, 2));
        obj.update(5, 6);
        System.out.println(obj.sumRange(3, 8));
    }

    static class NumArray {

        int[] nums;
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            n = nums.length;
            this.nums = nums;
            tree = new int[4 * n];
            segmentTree(1, 0, n - 1);
//            System.out.println(Arrays.toString(tree));
        }

        public void segmentTree(int node, int start, int end) {
//            System.out.println(start+" "+end+" "+node);
            if (start == end) {
                tree[node] = nums[start];
            } else {
                int mid = (start + end) / 2;
                segmentTree(2 * node, start, mid);
                segmentTree(2 * node + 1, mid + 1, end);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        public void update(int index, int val) {
            updateTree(index, val, 0, n - 1, 1);
        }

        public void updateTree(int index, int val, int start, int end, int node) {
            if (start == end) {
                nums[index] = val;
                tree[node] = val;
            } else {
                int mid = (start + end) / 2;
                if (mid >= index) {
                    updateTree(index, val, start, mid, 2 * node);
                } else {
                    updateTree(index, val, mid + 1, end, 2 * node + 1);
                }
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        public int sumRange(int left, int right) {
            return calcSum(1, 0, n - 1, left, right);
        }

        public int calcSum(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int p1 = calcSum(2 * node, start, mid, l, r);
            int p2 = calcSum(2 * node + 1, mid + 1, end, l, r);
            return p1 + p2;
        }
    }
}
