package LeetCode;// Java program to find shortest path in an undirected
// graph

import java.util.*;

public class OpenTheLock {

    // Driver Program
    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public static boolean[] dead;

    public static int openLock(String[] deadends, String target) {
        dead = new boolean[10000];
        Arrays.fill(dead, false);
        for (String deadend : deadends) {
            int num = Integer.parseInt(deadend);
            dead[num] = true;
        }
        // No of vertices
        int v = 10000;
        // Adjacency list for storing which vertices are connected
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        int source = 0;
        int dest = Integer.parseInt(target);
        if(dest == 0) {
            if(!dead[0])
                return 0;
            else
                return -1;
        }

        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        for (int i = 0; i < 10000; i++) {
            String str = "";
            if (i < 10) {
                str = "000" + i;
            } else if (i < 100) {
                str = "00" + i;
            } else if (i < 1000) {
                str = "0" + i;
            } else {
                str = str + i;
            }
            int from = Integer.parseInt(str);
            for (int j = 0; j < 4; j++) {
                char[] ch = str.toCharArray();
                int index = ch[j] - 48;
                if (index == 9) {
                    ch[j] = '0';
                    int to = Integer.parseInt(String.valueOf(ch));
                    if (!dead[to] && !dead[from])
                        addEdge(adj, from, to);
                    ch[j] = '8';
                    to = Integer.parseInt(String.valueOf(ch));
                    if (!dead[to] && !dead[from])
                        addEdge(adj, from, to);
                } else if (index == 0) {
                    ch[j] = '1';
                    int to = Integer.parseInt(String.valueOf(ch));
                    if (!dead[to] && !dead[from])
                        addEdge(adj, from, to);
                    ch[j] = '9';
                    to = Integer.parseInt(String.valueOf(ch));
                    if (!dead[to] && !dead[from])
                        addEdge(adj, from, to);
                } else {
                    ch[j] = (char) (index - 1 + 48);
                    int to = Integer.parseInt(String.valueOf(ch));
                    if (!dead[to] && !dead[from])
                        addEdge(adj, from, to);
                    ch[j] = (char) (index + 1 + 48);
                    to = Integer.parseInt(String.valueOf(ch));
                    if (!dead[to] && !dead[from])
                        addEdge(adj, from, to);
                }
            }
        }
        return getShortestDistance(adj, source, dest, v);
    }

    // function to form edge between two vertices
    // source and dest
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    // function to print the shortest distance and path
    // between source vertex and destination vertex
    private static int getShortestDistance(
            ArrayList<ArrayList<Integer>> adj,
            int s, int dest, int v) {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        int[] pred = new int[v];
        int[] dist = new int[v];

        if (!BFS(adj, s, dest, v, pred, dist)) {
            return -1;
        }

        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // Print path
//        System.out.println("Path is ::");
//        for (int i = path.size() - 1; i >= 0; i--) {
//            System.out.print(path.get(i) + " ");
//        }

        // Print distance
        return dist[dest];

    }

    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
                               int dest, int v, int[] pred, int[] dist) {
        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        LinkedList<Integer> queue = new LinkedList<>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean[] visited = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (!visited[adj.get(u).get(i)]) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    // stopping condition (when we find
                    // our destination)
                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
