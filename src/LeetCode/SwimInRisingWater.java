package LeetCode;

public class SwimInRisingWater {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        int c = 0;
        int[][] grid = new int[50][50];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i % 2 == 0) {
                    grid[i][j] = c;
                } else {
                    grid[i][grid.length-j-1] = c;
                }
                c++;
            }
        }
        count = 0;
        System.out.println(swimInWater(grid));
        System.out.println(count);
    }

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
//        System.out.println(n);
        int start = 0;
        int end = n * n - 1;
        int ans = end;
        while (start <= end) {
            int mid = (start + end) / 2;
//            System.out.println(mid);
            if (check(grid, mid, n)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean check(int[][] grid, int mid, int n) {
        visited = new boolean[n][n];
        return checkRecursive(grid, mid, n, 0, 0);
    }

    static boolean[][] visited;
    static long count;

    private static boolean checkRecursive(int[][] grid, int mid, int n, int i, int j) {
//        System.out.println(i + " " + j);
//        System.out.println(grid.length);
//        count++;
        if (i < 0 || j < 0 || i >= n || j >= n) {
//            System.out.println("Inside 1st if");
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (grid[i][j] > mid) {
//            System.out.println("Inside 2nd if");
            return false;
        }
        if (i == n - 1 && j == n - 1) {
//            System.out.println("Inside 3rd if");
            return true;
        }
        visited[i][j] = true;
        return checkRecursive(grid, mid, n, i, j + 1) ||
                checkRecursive(grid, mid, n, i + 1, j) ||
                checkRecursive(grid, mid, n, i, j - 1) ||
                checkRecursive(grid, mid, n, i - 1, j);
    }
}
