package Hacktag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Submatrix {
    public static void main(String args[]) {
        int[][] numbers = new int[][]
                {
                        {1,2,3,2,5,7},
                        {4,5,6,1,7,6},
                        {7,8,9,4,8,3}
                };
        boolean[] result = isSubmatrixFull(numbers);
//        System.out.println(result);
        System.out.print("[");
        for(boolean x: result)
            System.out.print(x+",");
        System.out.println("]");
    }

    public static boolean[] isSubmatrixFull(int[][] numbers) {
        int rows = numbers.length;
        int cols = numbers[0].length;
        boolean[] list = new boolean[cols-2];
        for(int j=0; j < cols-2; j++){
            int sum = 0;
            boolean[] numUsed = new boolean[9];
            Arrays.fill(numUsed, Boolean.FALSE);
            for(int i=0; i<rows; i++){
                for(int k = j; k<(j+rows); k++){
                    numUsed[numbers[i][k]-1] = true;
                    sum += numbers[i][k];
                }
            }
            if(sum == 45) {
                boolean flag = true;
                for (boolean b : numUsed) {
                    if (!b) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list[j] = true;
                }
            } else {
                list[j] = false;
            }
        }
        return list;
    }
}
