package Foobar;

import java.util.Arrays;

public class GearingUpForDestruction {
    public static void main(String[] args) {
//        int[] arr1 = {13, 5, 6, 2, 5};
//        int[] arr2 = {5, 2, 5, 13};
//        int[] arr1 = {14, 27, 1, 4, 2, 50, 3, 1};
//        int[] arr2 = {2, 4, -4, 3, 1, 1, 14, 27, 50};
        int[] arr = {4, 30, 50};
        System.out.println(Arrays.toString(solution(arr)));
//        GCD(90, 3);
    }

    private static int[] solution(int[] pegs) {
        int[] solution = {-1, -1};
        int[] diff = new int[pegs.length - 1];
        for (int i = 0; i < pegs.length - 1; i++) {
            diff[i] = pegs[i + 1] - pegs[i];
        }
        int a = 0;
        int mFactor = 1;
        for (int j : diff) {
            a += mFactor * j;
            mFactor *= -1;
        }
        a *= 2;
        int b = (pegs.length % 2 == 0) ? 3 : 1;

        if (a % b == 0) {
            a = a / b;
            b = 1;
        }
        float distance = ((float) a) / ((float) b);
        for (int i = 0; i < pegs.length - 2; i++) {
            float max = (float) pegs[i + 1] - pegs[i];
            if (distance < 0 || distance > max - 1)
                return solution;
            distance = max - distance;
        }
        return new int[]{a, b};
    }


//    private static int[] solution(int[] pegs) {
//        int[] solution = {-1, -1};
//        for (int i = 2; i <= pegs[1] - pegs[0]; i+=2) {
//            for (int j = 1 ; j <= i/2; j++) {
////                float index = pegs[0];
//                float r1 = (float) i/j;
//                float endRadius = (float) i/j;
//                for (int k = 0; k < pegs.length - 1; k++) {
//                    float startRadius = endRadius;
//                    float index = pegs[k] + startRadius;
//                    endRadius = pegs[k+1] - index;
//                }
//                if (r1 == 2*endRadius) {
//                    solution[0] = i;
//                    solution[1] = j;
//                    return solution;
//                }
//            }
//        }
//        return solution;
//    }

//    public static int[] solution(int[] pegs) {
//        int[] solution = {-1, -1};
//        if (pegs.length == 1) {
//            return solution;
//        }
//        int[] diff = new int[pegs.length - 1];
//        for (int i = 0; i < pegs.length - 1; i++) {
//            diff[i] = pegs[i + 1] - pegs[i];
//        }
//        int sum = 0;
//        int mFactor = 1;
//        for (int i = 0; i < diff.length; i++) {
//            sum += mFactor * diff[i];
//            mFactor *= -1;
//        }
//        if(sum < 2) {
//            return solution;
//        }
//        sum *= 2;
//        if (pegs.length % 2 != 0) {
//            solution[0] = sum;
//            solution[1] = 1;
//        } else {
//            if (GCD(sum, 3) == 1) {
//                solution[0] = sum;
//                solution[1] = 3;
//            } else if {
//                solution[0] = sum/3;
//                solution[1] = 1;
//            }
//        }
//        return solution;
//    }
//
//    public static int GCD(int n1, int n2) {
//        while(n1 != n2)
//        {
//            if(n1 > n2)
//                n1 -= n2;
//            else
//                n2 -= n1;
//        }
//        return n1;
//    }
}
