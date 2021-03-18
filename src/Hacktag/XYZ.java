package Hacktag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class XYZ {
    public static int[][] sortByBeauty(int[][] m, int size) {
        int rows = m.length;
        Map<Integer, List<int[][]>> map = new TreeMap<>();

        int[][] result = new int[rows][rows];
        for (int i=0; i<m.length; i+=size) {
            for (int j=0; j<m.length; j+=size) {
                fillMap(m, i, j, map, size);
            }
        }
        return result;
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
        System.out.println(sortByBeauty(numbers, 2));
    }
}
