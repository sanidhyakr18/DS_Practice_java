package HackerBlocks;

public class Practice {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        change(a);
        System.out.println(a);
    }

    public static void change(int a) {
        a = 20;
        System.out.println(a);
    }
}

//public class Practice {
//    public static void main(String[] args) {
//        int[] a = {10, 20};
//        System.out.println(a[0] + " " + a[1]);
//        change(a);
//        System.out.println(a[0] + " " + a[1]);
//    }
//
//    public static void change(int[] b) {
//        b[0] = b[1];
//        System.out.println(b[0] + " " + b[1]);
//    }
//}