package LeetCode;

import java.util.Arrays;

public class MaxAreaOfCake {
    public static void main(String[] args) {
        int h = 5, w = 4;
        int[] horizontalCuts = new int[]{1, 2, 4};
        int[] verticalCuts = new int[]{1, 3};
        System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
    }


    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length;
        int n = verticalCuts.length;
        int maxH = horizontalCuts[0];
        for (int i = 1; i < m; i++) {
            int curr = horizontalCuts[i] - horizontalCuts[i - 1];
            maxH = Integer.max(maxH, curr);
        }
        maxH = Integer.max(maxH, h - horizontalCuts[m - 1]);
        int maxV = verticalCuts[0];
        for (int i = 1; i < n; i++) {
            int curr = verticalCuts[i] - verticalCuts[i - 1];
            maxV = Integer.max(maxV, curr);
        }
        maxV = Integer.max(maxV, w - verticalCuts[n - 1]);
        return (int) (maxH % (1e9 + 7) * maxV % (1e9 + 7));
    }

//    To analyse
//    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
//        int maxH = 0;
//        int maxV = 0;
//        Arrays.sort(horizontalCuts);
//        Arrays.sort(verticalCuts);
//        for (int i = 0; i < horizontalCuts.length; i++) {
//            maxH = Math.max(maxH, i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1]);
//        }
//        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
//        for (int i = 0; i < verticalCuts.length; i++) {
//            maxV = Math.max(maxV, i == 0 ? verticalCuts[i] : verticalCuts[i] - verticalCuts[i - 1]);
//        }
//        maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);
//        return (int)(maxH % (1e9 + 7) * maxV % (1e9 + 7));
//    }
}
