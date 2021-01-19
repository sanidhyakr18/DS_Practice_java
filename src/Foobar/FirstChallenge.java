package Foobar;

public class FirstChallenge {
    public static void main(String[] args) {
//        int[] arr1 = {13, 5, 6, 2, 5};
//        int[] arr2 = {5, 2, 5, 13};
        int[] arr1 = {14, 27, 1, 4, 2, 50, 3, 1};
        int[] arr2 = {2, 4, -4, 3, 1, 1, 14, 27, 50};
        System.out.println(solution(arr1, arr2));
    }

    private static int solution(int[] x, int[] y) {
        int sumX = 0;
        int sumY = 0;
        int i = 0;
        while (i < x.length || i < y.length) {
            if (i< x.length) {
                sumX += x[i];
            }
            if (i< y.length) {
                sumY += y[i];
            }
            i++;
        }
        if (x.length > y.length) {
            return sumX - sumY;
        } else {
            return sumY - sumX;
        }
    }
}
