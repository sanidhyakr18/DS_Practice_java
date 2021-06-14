package LeetCode;

import java.util.Arrays;

public class MaximumUnitsOnTruck {
    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{1,3},{2,2},{3,1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }

    private static int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        Arrays.sort(boxTypes, (o1, o2) -> o2[1]-o1[1]);
        // for(int i = 0; i < n; i++) {
        //     System.out.println(boxTypes[i][0]+" "+boxTypes[i][1]);
        // }
        int boxes = 0;
        for(int i = 0; i < n && truckSize != 0; i++) {
            if(boxTypes[i][0] < truckSize) {
                boxes = boxes + boxTypes[i][0] * boxTypes[i][1];
                truckSize = truckSize - boxTypes[i][0];
            } else {
                boxes = boxes + truckSize * boxTypes[i][1];
                truckSize = 0;
            }
            // System.out.println(boxTypes[i][0]+" "+boxTypes[i][1]);
        }
        return boxes;
    }
}
