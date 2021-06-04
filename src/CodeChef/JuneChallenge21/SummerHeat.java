package CodeChef.JuneChallenge21;

import java.util.Scanner;

public class SummerHeat {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int xa = s.nextInt();
            int xb = s.nextInt();
            int Xa = s.nextInt();
            int Xb = s.nextInt();
            int ans = (Xa / xa) + (Xb / xb);
            if (Xa % xa != 0) {
                ans++;
            }
            if (Xb % xb != 0) {
                ans++;
            }
            System.out.println(ans);
        }
    }

}
