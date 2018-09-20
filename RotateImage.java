/**
 * Created on 20 Sep 2018 by happygirlzt
 *
 * LeetCode #48. Rotate Image
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - j - 1][i];
                matrix[row - j - 1][i] = matrix[i][j];
                System.out.println(matrix[row-j-1][i]);
                System.out.println(matrix[i][j]);
            }
        }
    }
}
