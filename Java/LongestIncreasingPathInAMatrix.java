/**
 * Created on 5 Nov 2018 by happygirlzt
 *
 * LeetCode #329. Longest Increasing Path in a Matrix
 *
 */

public class LongestIncreasingPathInAMatrix {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int[][] memo = new int[rowNum][colNum];

        int max = 1;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                int len = dfs(matrix, i, j, rowNum, colNum, memo);
                max = Math.max(max, len);
            }
        }

        return max;
    }

    public int dfs(int[][] m, int i, int j, int rowNum, int colNum, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];

        int max = 1;

        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= rowNum || y >= colNum || x < 0 || y < 0 || m[x][y] <= m[i][j]) {
                continue;
            }
            int len = 1 + dfs(m, x, y, rowNum, colNum, memo);
            max = Math.max(max, len);
        }

        memo[i][j] = max;
        return max;
    }
}
