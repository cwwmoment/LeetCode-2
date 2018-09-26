/**
 * Created on 26 Sep 2018 by happygirlzt
 *
 * LeetCode #63. Unique Paths II
 */

public class UniquePath2 {
    // 我的很丑的写法
    public int uniquePathsWithObstacles(int[][] og) {
        if (og.length == 0 || og[0].length == 0) return 0;

        int row = og.length;
        int col = og[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = 0;

        boolean flag = false;
        for (int i = 0; i < row; i++) {
            if (og[i][0] != 1 && flag == false) {
                dp[i][0] = 1;
            } else if (og[i][0] == 1) {
                flag = true;
                dp[i][0] = 0;
            } else {
                dp[i][0] = 0;
            }
        }

        flag = false;
        for (int i = 0; i < col; i++) {
            if (og[0][i] != 1 && flag == false) {
                dp[0][i] = 1;
            } else if (og[0][i] == 1) {
                flag = true;
                dp[0][i] = 0;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (og[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[row - 1][col - 1];
    }

    // Other's smart写法
    public int uniquePathsWithObstacles(int[][] og) {
        int n = og.length;
        int m = og[0].length;

        int[] dp = new int[m];
        dp[m-1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (og[i][j] == 1) {
                    dp[j] = 0;
                } else if (j < m - 1) {
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}
