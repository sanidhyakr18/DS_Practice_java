package Foobar;

import java.math.BigInteger;

public class SecondChallenge {
    public static void main(String[] args) {
//        int[] arr1 = {-2, -3, 4, -5};
//        int[] arr1 = {2, 0, 2, 2, 0};
//        int[] arr1 = {-2, -3, 4, 0, -5, -1 , 10 , 50 , -5, 10, 10, 10, 10, 100, -100, -100, 200, 10, 10, 10, 10, 100, -100, -100, 200};
//        int[] arr1 = {0, 0, 0};
//        int[] arr1 = {0, 0};
//        int[] arr1 = {0, 0, -1, 2};
//        int[] arr1 = {0, -1};

//        int[] arr1 = {2, 0, 2, 2, 0};
//        int[] arr1 = {-2, -3, 4, -5};
//        int[] arr1 = {0};
//        int[] arr1 = {1};
//        int[] arr1 = {0, 2, 2, -4, -2, -2};
//        int[] arr1 = {1, 1, 1, 1, 1, 1};
//        int[] arr1 = {-1, -1, -1, -1, -1, -1, -1};
//        int[] arr1 = {-1, -1, -1, -1, -1, -1};
//        int[] arr1 = {0, -1};
//        int[] arr1 = {-1};
//        int[] arr1 = {-8};
        int[] arr1 = {0, 0, -45, 0};

        System.out.println(solution(arr1));
    }

    private static String solution(int[] xs) {
        if (xs.length == 1) {
            return Integer.toString(xs[0]);
        }
        int negCount = 0;
        int posCount = 0;
        int max = -2000;
        BigInteger product = new BigInteger("1");
        String finalProduct = "1";
        for (int x : xs) {
            if (x != 0) {
                product = product.multiply(new BigInteger(Integer.toString(x)));
                finalProduct = product.toString();
                if (x < 0) {
                    negCount++;
                    max = Math.max(max, x);
                }
                if (x > 0) {
                    posCount++;
                }
            }
        }
        if (negCount % 2 != 0) {
            product = product.divide(new BigInteger(Integer.toString(max)));
            finalProduct = product.toString();
        }
        if (negCount == 1 && posCount == 0) {
            return "0";
        }
        if (negCount == 0 && posCount == 0) {
            return "0";
        }
        return finalProduct;
    }

//    public static String solution(int[] xs) {
//        if (xs.length == 1) {
//            return Integer.toString(Math.max(xs[0], 0));
//        }
//        int negCount = 0;
//        int posCount = 0;
//        int max = -2000;
//        long product;
//        String finalProduct = "1";
//        for (int x : xs) {
//            if (x != 0) {
//                product = Long.parseLong(finalProduct) * x;
//                finalProduct = Long.toString(product);
//                if (x < 0) {
//                    negCount++;
//                    max = Math.max(max, x);
//                }
//                if (x > 0) {
//                    posCount++;
//                }
//            }
//        }
//        if (negCount % 2 != 0) {
//            product = Long.parseLong(finalProduct) / max;
//            finalProduct = Long.toString(product);
//        }
//        if (negCount == 1 && posCount == 0) {
//            return "0";
//        }
//        if (negCount == 0 && posCount == 0) {
//            return "0";
//        }
//        return finalProduct;
//    }
}




//System.out.println(x + "\t" + finalProduct + "\t" + product + "\t" + count + "\t" + max);