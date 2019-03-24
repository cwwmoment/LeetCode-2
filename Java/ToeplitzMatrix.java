/**
 * Created on 22 Nov 2018 by happygirlzt
 *
 * LeetCode #766. Toeplitz Matrix
 *
 */

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] m) {
        if (m == null || m.length == 0) return true;
        int row = m.length, col = m[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) continue;

                visited[i][j] = true;
                int x = i, y = j;
                while (x + 1 < row && y + 1 < col) {
                    if (m[x][y] == m[x + 1][y + 1]) {
                        x++;
                        y++;
                        visited[x][y] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Updated on 24 Mar 2019
    public boolean isToeplitzMatrix1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return true;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
                }
            }
        }
        return true;
    }
}
