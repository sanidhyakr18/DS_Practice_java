package Hacktag;

import java.util.*;

public class ABC {
    public static int[][] beautifyMatrix(int[][] m, int size) {

        Map<Integer, List<int[][]>> map = new TreeMap<>();

        for (int i=0; i<m.length; i+=size) {

            for (int j=0; j<m.length; j+=size) {

                fillMap(m, i, j, map, size);

            }

        }

        int [][] res = new int[m.length][m.length];

        int i = 0;

        int j = 0;

        for (Map.Entry<Integer, List<int[][]>> entry : map.entrySet()) {

            for (int[][] sub : entry.getValue()) {

                for (int k=0; k<sub.length; k++) {

                    for (int l=0; l<sub.length; l++) {

                        res[k+i][j+l] = sub[k][l];

                    }

                }

            }

            if (j < m.length) {

                j += size;

            }

            else {

                i += size;

                j = 0;

            }

        }

        return res;

    }

    private static void fillMap(int [][] m, int i, int j, Map<Integer, List<int[][]>> map, int size) {

        int [][] subM = new int[size][size];

        int row = 0;

        int col = 0;

        for (int k=i; k<size; k++) {

            for (int l=j; l<size; l++) {

                subM[row][col++] = m[k][j];

            }

            row++;

        }

        int beauty = getBeauty(subM, size);

        List<int[][]> subs = map.getOrDefault(beauty, new ArrayList<>());

        subs.add(subM);

        map.put(beauty, subs);

    }

    private static int getBeauty(int[][] m, int size) {

        int total = (size * size+1)/2;

        for (int i=0; i<m.length; i++) {

            for (int j=0; j<m.length; j++) {

                total -= m[i][j];

            }

        }

        return total;

    }

    public static void main(String[] args) {
        int[][] numbers = new int[][]{{1,2,2,3},{3,4,10,4},{2,10,1,2}, {5,4,4,5}};
        System.out.println(Arrays.deepToString(beautifyMatrix(numbers, 2)));
    }
}
