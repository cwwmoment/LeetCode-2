/**
 * Created on 18 Jan 2019 by happygirlzt
 *
 * LeetCode #311. Sparse Matrix Multiplication
 *
 */

class Solution {
    // brute force
    public int[][] multiply0(int[][] A, int[][] B) {
        int row = A.length, col = B[0].length;
        int mid = A[0].length;
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // This is the difference
                for (int k = 0; k < mid; k++) {  
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return res;
    }

    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length, col = B[0].length;
        int mid = A[0].length;
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            // This is the smart part
            for (int k = 0; k < mid; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < col; j++) {
                        // This is the smart part
                        if (B[k][j] != 0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }

        return res;
    }
}
