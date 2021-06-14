package LeetCode;

public class LargestMagicSquare {

    public static void main(String[] args) {
        int[][] arr = new int[][] {{5,1,3,1},{9,3,3,1},{1,3,3,8}};
        System.out.println(largestMagicSquare(arr));
    }

    public static int largestMagicSquare(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] rowSums = new int[M + 1][N + 1];
        int[][] colSums = new int[M + 1][N + 1];
        int[][] diaSums = new int[M + 1][N + 1];
        int[][] antiDiaSums = new int[M + 1][N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rowSums[i + 1][j + 1] = rowSums[i + 1][j] + matrix[i][j];
                colSums[i + 1][j + 1] = colSums[i][j + 1] + matrix[i][j];
                diaSums[i + 1][j + 1] = diaSums[i][j] + matrix[i][j];
                antiDiaSums[M - i - 1][N - j] = antiDiaSums[M - i][N - j - 1] + matrix[M - i - 1][N - j - 1];
            }
        }

        int max = 1;

        for (int size = 2; size <= Math.min(M, N); size++) {
            for (int i = size - 1; i < M; i++) {
                for (int j = size - 1; j < N; j++) {
                    boolean areRowsValid = true;
                    int effectiveRowSum = rowSums[i + 1][j + 1] - rowSums[i + 1][j + 1 - size];
                    for (int k = i - size + 1; k < i; k++) {
                        if (rowSums[k + 1][j + 1] - rowSums[k + 1][j + 1 - size] != effectiveRowSum) {
                            areRowsValid = false;
                            break;
                        }
                    }

                    if (!areRowsValid) continue;

                    boolean areColsValid = true;
                    int effectiveColSum = colSums[i + 1][j + 1] - colSums[i - size + 1][j + 1];
                    if (effectiveColSum != effectiveRowSum) continue;
                    for (int k = j - size + 1; k < j; k++) {
                        if (colSums[i + 1][k + 1] - colSums[i + 1 - size][k + 1] != effectiveColSum) {
                            areColsValid = false;
                            break;
                        }
                    }

                    if (!areColsValid) continue;

                    int diaSum = diaSums[i + 1][j + 1] - diaSums[i + 1 - size][j + 1 - size];
                    int antiDiaSum = antiDiaSums[i + 1 - size][j + 1] - antiDiaSums[i + 1][j + 1 - size];
                    if (diaSum == effectiveColSum && diaSum == antiDiaSum) max = Math.max(max, size);
                }
            }
        }
        return max;
    }

//    public static int largestMagicSquare(int[][] arr) {
//        int m = arr.length;
//        int n = arr[0].length;
//        int k = 1;
//        int min = Math.min(m,n);
//        int[][] row = new int[m][n];
//        int[][] col = new int[m][n];
//        int[][] dia = new int[m][n];
//        int[][] adia = new int[m][n];
//
//        for(int i = 0; i < m; i++) {
//            row[i][0] = arr[i][0];
//            for(int j = 1; j < n; j++) {
//                row[i][j] = row[i][j-1] + arr[i][j];
//            }
//        }
//
//        for(int i = 0; i < n; i++) {
//            col[0][i] = arr[0][i];
//            for(int j = 1; j < m; j++) {
//                col[j][i] = col[j-1][i] + arr[j][i];
//            }
//        }
//
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                if(i == 0) dia[i][j] = arr[i][j];
//                else if (j == 0) dia[i][j] = arr[i][j];
//                else dia[i][j] = dia[i-1][j-1] + arr[i][j];
//            }
//        }
//
//        for(int i = 0; i < m; i++) {
//            for(int j = n - 1; j >= 0; j--) {
//                if(i == 0) adia[i][j] = arr[i][j];
//                else if (j == n-1) adia[i][j] = arr[i][j];
//                else adia[i][j] = adia[i-1][j+1] + arr[i][j];
//            }
//        }
//
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                for(int size = min; size >= 2; size--) {
//                    int found = 0;
//                    if(i + size <= m && j + size <= n) {
//                        int sum;
//                        if(i == 0 || j == 0) {
//                            sum = dia[i + size - 1][j + size - 1];
//                            if(sum != adia[i+size-1][j]) continue;
//
//                            int curr = 0;
//                            int flag = 0;
//                            for(int x = 0; x < size; x++) {
//                                if(j == 0) {
//                                    curr = row[i][j+size-1];
//                                } else {
//                                    curr = row[i][j+size-1] - row[i][j-1];
//                                }
//                                if(curr!= sum) {
//                                    break;
//                                }
//                            }
//                            if(curr!= sum) continue;
//                            for(int x = 0; x < size; x++) {
//                                if(i == 0) {
//                                    curr = col[i+size-1][j];
//                                } else {
//                                    curr = col[i+size-1][j] - col[i-1][j];
//                                }
//                                if(curr!= sum) {
//                                    break;
//                                }
//                            }
//                            if(curr!= sum) continue;
//                        } else {
//                            sum = dia[i + size - 1][j + size - 1] - dia[i - 1][j - 1];
//                            if(j+size == n) {
//                                if(sum != adia[i+size-1][j]) continue;
//                            } else {
//                                if(sum != adia[i+size-1][j] - adia[i-1][j+size]) continue;
//                            }
//
//                            int curr = 0;
//                            int flag = 0;
//                            for(int x = 0; x < size; x++) {
//                                curr = row[i][j+size-1] - row[i][j-1];
//                                if(curr!= sum) {
//                                    break;
//                                }
//                            }
//                            if(curr!= sum) continue;
//                            for(int x = 0; x < size; x++) {
//                                curr = col[i+size-1][j] - col[i-1][j];
//                                if(curr!= sum) {
//                                    break;
//                                }
//                            }
//                            if(curr!= sum) continue;
//                        }
//                        found = 1;
//
//                    }
//                    if(found == 1) {
//                        k = Math.max(k, size);
//                        break;
//                    }
//                }
//            }
//        }
//        return k;
//    }

//    public int largestMagicSquare(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int k = 1;
//        int min = Math.min(m,n);
//        for(int size = 2; size <= min; size++) {
//            int found = 0;
//            for(int i = 0; i <= grid.length - size; i++) {
//                for(int j = 0; j <= grid[0].length - size; j++) {
//                    int flag = 0;
//                    int sum = 0;
//
//                    for(int x = i; x < i + size; x++) {
//                        int currSum = 0;
//                        for(int y = j; y < j + size; y++) {
//                            currSum = currSum + grid[x][y];
//                        }
//                        if(x == i) {
//                            sum = currSum;
//                        } else {
//                            if(currSum != sum) {
//                                flag = 1;
//                                break;
//                            }
//                        }
//                    }
//
////                    if(flag == 1) {
////                        break;
////                    }
//
//                    for(int x = i; x < i + size && flag != 1; x++) {
//                        int currSum = 0;
//                        for(int y = j; y < j + size; y++) {
//                            currSum = currSum + grid[y][x];
//                        }
//                        if(currSum != sum) {
//                            flag = 1;
//                            break;
//                        }
//                    }
//
////                    if(flag == 1) {
////                        break;
////                    }
//
//                    int currSum = 0;
//                    for(int x = 0; x < size  && flag != 1; x++) {
//                        currSum = currSum + grid[i+x][j+x];
//                    }
//
//                    if(currSum != sum) {
//                        flag = 1;
//                    }
//
//                    currSum = 0;
//                    for(int x = 0; x < size  && flag != 1; x++) {
//                        currSum = currSum + grid[i + x][j + size - x - 1];
//                    }
//
//                    if(currSum != sum) {
//                        break;
//                    }
//                    found = 1;
//                }
//                if(found == 1) {
//                    break;
//                }
//            }
//
//            if(found == 1) {
//                k = size;
//            }
//        }
//        return k;
//    }
}
