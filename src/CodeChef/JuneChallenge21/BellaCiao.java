package CodeChef.JuneChallenge21;

import java.util.Scanner;

public class BellaCiao {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int D = s.nextInt();
            int d = s.nextInt();
            int P = s.nextInt();
            int Q = s.nextInt();
            int n = D / d - 1;
            int sum = D * P + d * n * (n + 1) * Q / 2;
            if (D % d != 0) {
                int r = D % d;
                sum += r * Q * (n + 1);
            }
            System.out.println(sum);
        }
    }
}
