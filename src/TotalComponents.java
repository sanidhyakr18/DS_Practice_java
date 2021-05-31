import java.util.Arrays;
import java.util.Scanner;

public class TotalComponents {

    public static int[] b;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        b = new int[10000005];
        Arrays.fill(b, 0);
        calcPrime();
        while (t > 0) {
            int n = s.nextInt();
            System.out.println(components(n));
            t--;
        }
    }

    private static int components(int n) {
        int index = n/2+1;
        int count = 0;
        for (int i = index; i <= n; i++) {
            if(b[i] == 0 && i > 2)
                count++;
        }
        return 1 + count;
    }

    public static void calcPrime() {
        for (int i = 2; i <= (int) Math.pow(b.length, 0.5); i++) {
            for (int j = 2; j <= i; j++)
                if(i*j < b.length)
                    b[i * j] = 1;
        }
    }
}
