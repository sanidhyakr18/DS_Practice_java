import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Binary Matrix of size N
        String[] mat = {"0010010",
                "1010101",
                "1111111",
                "0010000",
                "0000000"};
        System.out.println(biggestPlus(mat));
    }

    private static int biggestPlus(String[] matrix) {
        int size = 0;
        int rows = matrix.length;
        int cols = matrix[0].length();
        int[][] mat = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = matrix[i].charAt(j) - 48;
            }
        }
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(mat[i][j] + " ");
//            }
//            System.out.println();
//        }

        // left[j][j], right[i][j], top[i][j] and
        // bottom[i][j] store maximum number of
        // consecutive 1's present to the left,
        // right, top and bottom of mat[i][j]
        // including cell(i, j) respectively
        int[][] left = new int[rows][cols];
        int[][] right = new int[rows][cols];
        int[][] top = new int[rows][cols];
        int[][] bottom = new int[rows][cols];

        // initialize above four matrix
        for (int i = 0; i < cols; i++) {

            // initialize first row of top
            top[0][i] = mat[0][i];

            // initialize last row of bottom
            bottom[rows - 1][i] = mat[rows - 1][i];
        }

        for (int i = 0; i < rows; i++) {
            // initialize first column of left
            left[i][0] = mat[i][0];

            // initialize last column of right
            right[i][cols - 1] = mat[i][cols - 1];
        }

        // fill all cells of above four matrix
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {

                // calculate left matrix
                // (filled left to right)
                if (mat[i][j] == 1)
                    left[i][j] = left[i][j - 1] + 1;
                else
                    left[i][j] = 0;

                // calculate top matrix
                if (mat[i][j] == 1)
                    top[i][j] = top[i - 1][j] + 1;
                else
                    top[i][j] = 0;

                // calculate new value of j to
                // calculate value of bottom(i, j)
                // and right(i, j)
                int tempI = i;
                int tempJ = j;
                i = cols - 1 - j; //replace with rows if not working
                j = i;
                if(i < rows && j < cols){
                    // calculate bottom matrix
                    if (mat[i][j] == 1)
                        bottom[i][j] = bottom[i + 1][j] + 1;
                    else
                        bottom[i][j] = 0;
                    // calculate right matrix
                    if (mat[i][j] == 1)
                        right[i][j] = right[i][j + 1] + 1;
                    else
                        right[i][j] = 0;

                }
                i = tempI;
                j = tempJ;
                // revert back to old j
            }
        }
        int n = 0;

        // compute longest +
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // find minimum of left(i, j),
                // right(i, j), top(i, j),
                // bottom(i, j)
                int len = Math.min(Math.min(top[i][j],
                        bottom[i][j]), Math.min(left[i][j],
                        right[i][j]));

                // largest + would be formed by a
                // cell that has maximum value
                if (len > n)
                    n = len;
            }
        }

        // 4 directions of length n - 1 and 1 for
        // middle cell
        if (n > 0)
            return n + 1;

        // matrix contains all 0's
        return 0;
    }

}