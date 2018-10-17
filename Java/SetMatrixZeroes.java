/**
 * Created on 18 Sep 2018 by happygirlzt
 *
 * LeetCode #73. Set Matrix Zeroes
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // My naive solution
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        boolean[] flag = new boolean[rowNum + colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == 0) {
                    flag[i] = true;
                    break;
                }
            }
        }

        for (int j = 0; j < colNum; j++) {
            for (int i = 0; i < rowNum; i++) {
                if (matrix[i][j] == 0) {
                    flag[rowNum + j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < rowNum; i++) {
            if (flag[i] == true) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int j = 0; j < colNum; j++) {
            if (flag[rowNum + j] == true) {
                for (int i = 0; i < rowNum; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Other's smart solution
    public void setZeroes(intp[][] matrix) {
        int rowNum = matrix.length, colNum = matrix[0].length;

        boolean fr = false, fc = false;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                }
            }
        }

        // first row
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (fr) {
            for (int j = 0; j < colNum; j++) matrix[0][j] = 0;
        }

        if (fc) {
            for (int i = 0; i < rowNum; i++) matrix[i][0] = 0;
        }
    }
}
