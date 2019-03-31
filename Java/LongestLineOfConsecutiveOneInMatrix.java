/**
 * Created on 10 Dec 2018 by happygirlzt
 *
 * LeetCode #562. Longest Line of Consecutive One in Matrix
 *
 */

class Solution {
    public int longestLine(int[][] m) {
        if (m == null || m.length == 0) return 0;
        int[][][] dp = new int[m.length + 1][m[0].length + 2][4];
        int res = 0;

        for (int i = 1; i <= m.length; i++) {
            for (int j = 1; j <= m[0].length; j++) {
                if (m[i - 1][j - 1] == 1) {
                    res = Math.max(res, dp[i][j][0] = dp[i][j - 1][0] + 1);  // row
                    res = Math.max(res, dp[i][j][1] = dp[i - 1][j][1] + 1);  // col
                    res = Math.max(res, dp[i][j][2] = dp[i - 1][j - 1][2] + 1);  // dis
                    res = Math.max(res, dp[i][j][3] = dp[i - 1][j + 1][3] + 1);
                }
            }
        }

        return res;
    }

    // Updated on 31 Mar 2019
    public int longestLine1(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int rows = M.length, cols = M[0].length;

        int[][][] dp = new int[rows + 1][cols + 2][4];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (M[i][j] == 1) {
                    dp[i + 1][j + 1][0] = dp[i][j + 1][0] + 1;
                    res = Math.max(res, dp[i + 1][j + 1][0]);

                    dp[i + 1][j + 1][1] = dp[i + 1][j][1] + 1;
                    res = Math.max(res, dp[i + 1][j + 1][1]);

                    dp[i + 1][j + 1][2] = dp[i][j][2] + 1;
                    res = Math.max(res, dp[i + 1][j + 1][2]);

                    dp[i + 1][j + 1][3] = dp[i][j + 2][3] + 1;
                    res = Math.max(res, dp[i + 1][j + 1][3]);
                }
            }
        }

        return res;
    }
}
