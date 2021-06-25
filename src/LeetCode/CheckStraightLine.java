package LeetCode;

public class CheckStraightLine {
    public static void main(String[] args) {
//        int[][] coordinates = new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
//        int[][] coordinates = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
//        int[][] coordinates = new int[][]{{2, 1}, {4, 2}, {6, 3}};
        int[][] coordinates = new int[][]{{2, 4}, {2, 5}, {2, 8}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] arr) {
        if (arr.length == 2)
            return true;

        float m;
        boolean reverse = false;
        if (arr[1][0] != arr[0][0]) {
            m = ((float) (arr[1][1] - arr[0][1]) / (float) (arr[1][0] - arr[0][0]));
        } else {
            m = (float) (0);
            reverse = true;
        }
        System.out.println(m);
        for (int i = 2; i < arr.length; i++) {
            if (!reverse && arr[i][1] - arr[0][1] != m * (arr[i][0] - arr[0][0]))
                return false;
            else if (reverse && m * (arr[i][1] - arr[0][1]) != (arr[i][0] - arr[0][0]))
                return false;
        }

        return true;
    }
}
