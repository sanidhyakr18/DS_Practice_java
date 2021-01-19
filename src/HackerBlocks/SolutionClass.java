package HackerBlocks;

import java.util.Scanner;

public class SolutionClass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String text = s.nextLine();
//        System.out.println();
        int t = s.nextInt();
        String toSearch = s.next();

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(text.charAt(i) == toSearch.charAt(0)) {
                int flag = 0;
                for(int j = i + 1; j < i + t; j++) {
                    if(text.charAt(j) != toSearch.charAt(j-i)) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
