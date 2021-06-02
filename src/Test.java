public class Test {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(a[5]);
        change(a);
        System.out.println(a[5]);
    }

    private static void change(int[] b) {
        b[5] = 0;
    }
}
