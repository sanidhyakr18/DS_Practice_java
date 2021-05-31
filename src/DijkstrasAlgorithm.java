import java.util.Scanner;

class DijkstrasAlgorithm {

    private static final int NO_PARENT = -1;

    private static void dijkstra(int[][] adjacencyMatrix,
                                 int startVertex) {
        int nVertices = adjacencyMatrix[0].length;
        int[] shortestDistances = new int[nVertices];

        boolean[] added = new boolean[nVertices];
        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[startVertex] = 0;
        int[] parents = new int[nVertices];
        parents[startVertex] = NO_PARENT;

        for (int i = 1; i < nVertices; i++) {

            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++) {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;

            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++) {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents);
    }

    private static void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents) {
        int nVertices = distances.length;
        int i = arr.length;
        int j = arr[0].length;
        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++) {
            if (vertexIndex == 0 || vertexIndex == (i - 1) * j || vertexIndex == j - 1 || vertexIndex == i * j - 1) {
                printPath(vertexIndex, parents);
                System.out.println();
            }
        }
    }

    private static void printPath(int currentVertex,
                                  int[] parents) {
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + 1 + " ");
    }

    public static int[][] arr;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();
        int source = s.nextInt();
        source = source - 1;

        int V = row * col;
        arr = new int[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = count++;
            }
        }

        int[][] adjacencyMatrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

        for (int i = 0; i < V; i++) {
            int from = s.nextInt();
            int to;
            from = from - 1;
            for (int j = 1; j <= 8; j++) {
                int dir = s.nextInt();
                if (dir == 1) {
                    to = getTo(arr, from, j, row, col);
                    adjacencyMatrix[i][to] = 1;
                }
            }
        }
        dijkstra(adjacencyMatrix, source);
    }

    private static int getTo(int[][] arr, int from, int dir, int row, int col) {
        int i = from / col;
        int j = from % col;
        switch (dir) {
            case 1:
                return arr[i - 1][j];
            case 2:
                return arr[i - 1][j + 1];
            case 3:
                return arr[i][j + 1];
            case 4:
                return arr[i + 1][j + 1];
            case 5:
                return arr[i + 1][j];
            case 6:
                return arr[i + 1][j - 1];
            case 7:
                return arr[i][j - 1];
            case 8:
                return arr[i - 1][j - 1];
        }
        return 0;
    }
}