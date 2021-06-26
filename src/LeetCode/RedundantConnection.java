package LeetCode;

import java.util.*;

public class RedundantConnection {
    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        int[][] arr = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(findRedundantConnection(arr)));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] ans = null;
        int n = edges.length;
        ArrayList<Set<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++)
            adjList.add(new HashSet<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dfs(u, v, 0, adjList)) {
                ans = edge;
            } else {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
        return ans;
    }

    private static boolean dfs(int u, int v, int parent, List<Set<Integer>> adjList) {
        if (u == v)
            return true;
        for (int w : adjList.get(u)) {
            if (w == parent) continue;
            boolean ans = dfs(w, v, u, adjList);
            if (ans) return true;
        }
        return false;
    }

}
