/**
 * Created on 2 Nov 2018 by happygirlzt
 *
 * LeetCode #115. Distinct Subsequences
 *
 */

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        // dp[i][j] means 0..i of t matches 0..j of s
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }

        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (tc[i] == sc[j]) {
                    dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
                } else {
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }

        return dp[tc.length][sc.length];
    }
}
