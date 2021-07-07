package HackerEarth;

public class MagicOfSquare {

    public static void main(String[] args) {
        long[] arr = new long[]{3, -4, 2, -6, -9};
        System.out.println(magicSquare(arr));
    }

    public static long magicSquare(long[] arr) {
        long pre = 0;
        long min_pre = 0;
        long f = Long.MAX_VALUE;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            f = Math.min(f, min_pre + arr[i] - arr[i] * arr[i]);
            pre = pre + arr[i];
            min_pre = Math.min(min_pre, pre);
            ans = Math.max(ans, pre - f);
            System.out.println(pre + "\t" + min_pre + "\t" + f + "\t" + ans);
        }
        return ans;
    }
}
