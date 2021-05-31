import java.util.*;

public class graph_prob {
    public static Stack<Integer> printhelper(int edges[][], int first, int second) {
        boolean visited[] = new boolean[edges.length];
        int parent[] = new int[edges.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(first);
        parent[first] = -1;
        visited[first] = true;
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (curr == second) {
                break;
            }
            for (int i = 0; i < edges.length; i++) {
                if (edges[curr][i] == 1) {
                    if (!visited[i]) {
                        q.add(i);
                        visited[i] = true;
                        parent[i] = curr;
                    }
                }
            }
        }
        Stack<Integer> l = new Stack<>();
        int curr = second;
        while (parent[curr] != -1) {
            l.push(curr + 1);
            curr = parent[curr];
        }
        l.push(first + 1);
        return l;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt();
        int n = s.nextInt();
        int position = s.nextInt();
        int direction[] = new int[]{-n, -(n - 1), 1, n + 1, n, n - 1, -1, -(n + 1)};
        int num_pixels = m * n;
        int connected[][] = new int[num_pixels][num_pixels];
        for (int i = 0; i < num_pixels; i++) {
            int extra = s.nextInt();
            for (int j = 0; j < 8; j++) {
                int x = s.nextInt();
                if (x == 1) {
                    connected[i][i + direction[j]] = 1;
                }
            }
        }

        int corner[] = new int[]{0, n - 1, num_pixels - n, num_pixels - 1};

        for (int i = 0; i < 4; i++) {
            Stack<Integer> a = printhelper(connected, position - 1, corner[i]);
            while (!a.isEmpty()) {
                System.out.print(a.pop() + " ");
            }
            System.out.println();
        }
    }


}