package LeetCode;

public class RemoveAllOccurrencesSubstring {
    public static void main(String[] args) {
        String s = "axxxxyyyyb";
        String part = "xy";
        System.out.println(removeOccurrences(s, part));
    }

    public static String removeOccurrences(String s, String part) {
        while(s.contains(part)) {
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + part.length(), s.length());
//            System.out.println(s);
        }
        return s;
    }
}
