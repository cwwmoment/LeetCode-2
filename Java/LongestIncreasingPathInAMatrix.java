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

    // Updated on 9 Mar 2019
    static final int[] r = {1, -1, 0, 0};
    static final int[] c = {0, 0, 1, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] dp) {
        if (dp[row][col] != 0) return dp[row][col];
        for (int i = 0; i < 4; i++) {
            int rr = r[i] + row;
            int cc = c[i] + col;
            if (rr >= 0 && cc >= 0 && rr < matrix.length && cc < matrix[0].length &&
                matrix[rr][cc] > matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], dfs(matrix, rr, cc, dp));
            }
        }
        dp[row][col] += 1;
        return dp[row][col];
    }


    // Updated on 5 Apr 2019
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == 0) {
                    dfs(matrix, i, j, dp, Integer.MIN_VALUE);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] dp, int prev) {
        if (row < 0 || row > matrix.length - 1 ||
            col < 0 || col > matrix[0].length - 1 ||
            matrix[row][col] <= prev) return 0;

        if (dp[row][col] != 0) return dp[row][col];

        int left = dfs(matrix, row, col - 1, dp, matrix[row][col]);
        int right = dfs(matrix, row, col + 1, dp, matrix[row][col]);
        int up = dfs(matrix, row - 1, col, dp, matrix[row][col]);
        int down = dfs(matrix, row + 1, col, dp, matrix[row][col]);
        dp[row][col] = Math.max(left, Math.max(right, Math.max(down, up))) + 1;
        return dp[row][col];
    }
}
