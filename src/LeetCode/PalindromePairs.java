package LeetCode;

import java.util.*;

public class PalindromePairs {
    public static void main(String[] args) {
        String[] str = new String[]{"abcd","dcba","lls","s","sssll"};
        System.out.println(palindromePairs(str));
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        if (map.containsKey("")) {
            int emptyStrIndex = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (emptyStrIndex != i && isPalindrome(words[i])) {
                    ans.add(Arrays.asList(i, emptyStrIndex));
                    ans.add(Arrays.asList(emptyStrIndex, i));
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(reversed)) {
                int reversedIndex = map.get(reversed);
                if (reversedIndex != i) {
                    ans.add(Arrays.asList(i, reversedIndex));
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j < word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                if(isPalindrome(left)){
                    Integer foundIndex = map.get(new StringBuilder(right).reverse().toString());
                    if(foundIndex != null){
                        ans.add(Arrays.asList(foundIndex, i));
                    }
                }

                if(isPalindrome(right)){
                    Integer foundIndex = map.get(new StringBuilder(left).reverse().toString());
                    if(foundIndex != null){
                        ans.add(Arrays.asList(i, foundIndex));
                    }
                }
            }
        }

        return ans;
    }

    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) if (str.charAt(i++) != str.charAt(j--)) return false;
        return true;
    }
}
