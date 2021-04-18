

public class InputTestCase {
    public static void main(String[] args) {
        int[][] arr = new int[][]
                {{1,0},
                        {1,2},
                        {8,5},
                        {9,7},
                        {5,6},
                        {5,4},
                        {4,6},
                        {6,7}}




                ;


        int n = 10;
        System.out.println(n);

        System.out.println(arr.length);

        for (int[] ints : arr) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
