/**
 * Created on 26 Sep 2018 by happygirlzt
 *
 * LeetCode #62. Unique Paths
 */

public class UniquePaths {
    // 我的寻常的dp解法
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[n-1][m-1];
    }

    // Other's smart solutin
    // 暂时没看懂。。。
    public int uniquePaths(int m, int n) {
        int N = n + m - 2; // how many steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;

        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }

        return (int) res;
    }
}
