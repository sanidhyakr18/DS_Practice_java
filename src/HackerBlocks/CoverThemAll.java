package HackerBlocks;

import java.util.Scanner;

public class CoverThemAll {

    static class Soldier {
        int coordinate;
        int bombs;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int size = s.nextInt();
            Soldier[] arr = new Soldier[size];
            for (int j = 0; j < size; j++) {
                arr[j] = new Soldier();
                arr[j].coordinate = s.nextInt();
            }
            for (int j = 0; j < size; j++) {
                arr[j].bombs = s.nextInt();
            }
            System.out.println(coverThemAll(arr));
        }
    }

    public static long coverThemAll(Soldier[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                sum = sum + (Math.abs(arr[i].coordinate-arr[j].coordinate)*Integer.max(arr[i].bombs,arr[j].bombs))%1000000007;
            }
        }
        return  sum%1000000007;
    }
}
//2
//        3
//        1 3 6
//        10 20 30
//        3
//        1 3 6
//        10 20 30