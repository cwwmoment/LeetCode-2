/**
 * Created on 26 Sep 2018 by happygirlzt
 *
 * LeetCode #64. Minimum Path Sum
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row+1][col+1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }

    // Updated on 24 Jan 2019
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (j == n - 1 && i != m - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (j != n - 1 && i != m - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
}
