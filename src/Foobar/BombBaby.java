package Foobar;

import java.math.BigInteger;

public class BombBaby {
    public static void main(String[] args) {
        System.out.println(solution("4", "7"));
    }

    static private boolean isPossible;

    public static BigInteger cycles(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.valueOf(0)) == 0)
            return a;
        else if (a.mod(b).equals(BigInteger.valueOf(0)) && b.compareTo(BigInteger.valueOf(1)) > 0)
            isPossible = false;
        return a.divide(b).add(cycles(b, a.mod(b)));
    }

    public static String solution(String x, String y) {
        BigInteger M = new BigInteger(x);
        BigInteger F = new BigInteger(y);
        isPossible = true;
        BigInteger result = cycles(M, F).subtract(BigInteger.valueOf(2));
        if (!isPossible)
            return "impossible";
        else
            return result.toString();
    }

//    private static String solution(String x, String y) {
//        BigInteger M = new BigInteger(x);
//        BigInteger F = new BigInteger(y);
//        BigInteger count = new BigInteger(Integer.toString(0));
//
//        while (M.compareTo(F) != 0) {
//            if(M.compareTo(F) > 0) {
//                BigInteger modulus = M.divide(F);
//                count = count.add(modulus);
//                M = M.mod(F);
//            } else if (F.compareTo(M) > 0) {
//                BigInteger modulus = F.divide(M);
//                count = count.add(modulus);
//                F = F.mod(M);
//            }
//        }
//        if(M.compareTo(new BigInteger("1")) == 0) {
//            return count.toString();
//        }
//        return "impossible";
//    }
}
