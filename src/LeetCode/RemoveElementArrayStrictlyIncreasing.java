package LeetCode;

import java.util.ArrayList;

public class RemoveElementArrayStrictlyIncreasing {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1};
        System.out.println(canBeIncreasing(arr));
    }

    public static boolean canBeIncreasing(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i < list.size(); i++) {
            if (check(list, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(ArrayList<Integer> list, int i) {
        int val = list.get(i);
        list.remove(i);
        for (int j = 1; j < list.size(); j++) {
            if (list.get(j) <= list.get(j - 1)) {
                list.add(i, val);
                return false;
            }
        }
        list.add(i, val);
        return true;
    }
}
