package LeetCode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
    }

    public static String removeDuplicates(String s) {
        if(s.length() == 0)
            return s;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) stack.push(s.charAt(i));
            else stack.pop();
        }
        StringBuilder myStr = new StringBuilder();
        while(!stack.isEmpty()) {
            myStr.append(stack.peek());
            stack.pop();
        }

        return myStr.reverse().toString();
    }
}
