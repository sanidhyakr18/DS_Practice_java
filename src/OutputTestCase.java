public class OutputTestCase {
    public static void main(String[] args) {
        int[] arr = new int[]
                {3, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 3, 2, 4, 1, 1, 1}


                ;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}
