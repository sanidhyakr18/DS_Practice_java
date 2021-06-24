package LeetCode;

import org.w3c.dom.Node;

import java.util.*;

public class NumOfMatchingSubsequences {
    public static void main(String[] args) {
        String[] words = new String[]{"a","bb","acd","ace"};
        String s = "abcde";
        System.out.println(numMatchingSubseq(s, words));
    }

    public static List[] list;

    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        list = new List['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (list[c - 'a'] == null)
                list[c - 'a'] = new ArrayList<>();
            list[c - 'a'].add(i);
        }

//        System.out.println(Arrays.toString(list));

        for (String word : words) {
            int val = -1;
            boolean found = true;
            for (int j = 0; j < word.length(); j++) {
                int curr = getIndex(word.charAt(j), val);
//                System.out.println(curr);
                if (curr == -1) {
                    found = false;
                    break;
                }
                val = curr;
            }
            if (found) count++;
        }
        return count;
    }

    private static int getIndex(char c, int curr) {
        if(list[c - 'a'] == null)
            return -1;
        int start = 0;
        int end = list[c - 'a'].size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int element = (int) list[c - 'a'].get(mid);
            if (element > curr) {
                ans = element;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

}
