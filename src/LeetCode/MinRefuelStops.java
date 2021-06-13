package LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinRefuelStops {
    public static void main(String[] args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(minRefuelStops(target, startFuel, stations));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] s) {
        int n = s.length;
        int[][] stations = new int[n+1][2];
        for (int i = 0; i < s.length; i++) {
            System.arraycopy(s[i], 0, stations[i], 0, 2);
        }
        stations[n][0] = target;
        stations[n][1] = 0;

        PriorityQueue<Integer> fuels = new PriorityQueue<>((a,b) -> b - a);
        int maxReachable = startFuel;
        int ans = 0;
        for (int[] station : stations) {
            while (!fuels.isEmpty() && maxReachable < station[0]) {
                ans++;
                maxReachable = maxReachable + fuels.peek();
                fuels.poll();
            }
            if (maxReachable < station[0]) {
                return -1;
            } else {
                fuels.add(station[1]);
            }
        }
        return ans;
    }
}
