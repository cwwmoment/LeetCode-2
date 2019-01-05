/**
 * Created on 5 Jan 2019 by happygirlzt
 *
 * LeetCode #498. Diagonal Traverse
 *
 */

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        int[] res = new int[m * n];

        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if (row > m - 1) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }

            if (col > n - 1) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            }

            if (row < 0) {
                row = 0;
                d = 1 - d;
            }
            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }

        return res;
    }
}
