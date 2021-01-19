package HackerBlocks;

import java.util.Scanner;

public class ChewbaccaAndNumber {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long[] arr = new long[18];
        int count = 0;
        while (n != 0) {
            arr[count++] = n % 10;
            n = n / 10;
        }
        for (int i = 0; i < count; i++) {
            if (i != count - 1) {
                if (arr[i] >= 5) {
                    arr[i] = 9 - arr[i];
                }
            } else {
                if (arr[i] >= 5 && arr[i] <= 8) {
                    arr[i] = 9 - arr[i];
                }
            }
        }
        for (int i = count - 1; i >= 0; i--) {
            n = n * 10 + arr[i];
        }
        System.out.println(n);
    }
}
