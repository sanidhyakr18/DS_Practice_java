package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CyclicallyRotatingGrid {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] grid = new int[][]{{1, 2, 3}, {1, 2, 3}};
        int k = 2;
        System.out.println(Arrays.deepToString(rotateGrid(grid, k)));
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for (int l = 0; l < Math.min(m, n) / 2; l++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = l; i < n - l - 1; i++) list.add(grid[l][i]);
            for (int i = l; i < m - l - 1; i++) list.add(grid[i][n - l - 1]);
            for (int i = n - l - 1; i > l; i--) list.add(grid[m - l - 1][i]);
            for (int i = m - l - 1; i > l; i--) list.add(grid[i][l]);

            int start = k % list.size();
            for (int i = l; i < n - l - 1; i++) grid[l][i] = list.get(start++ % list.size());
            for (int i = l; i < m - l - 1; i++) grid[i][n - l - 1] = list.get(start++ % list.size());
            for (int i = n - l - 1; i > l; i--) grid[m - l - 1][i] = list.get(start++ % list.size());
            for (int i = m - l - 1; i > l; i--) grid[i][l] = list.get(start++ % list.size());
        }
        return grid;
    }
}
