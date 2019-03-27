/**
 * Created on 27 Mar 2019 by happygirlzt
 *
 * LeetCode #343. Integer Break
 *
 */

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], (i - j) * j);
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }

        return dp[n];
    }
}
