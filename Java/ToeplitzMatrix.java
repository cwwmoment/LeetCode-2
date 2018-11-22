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
}
