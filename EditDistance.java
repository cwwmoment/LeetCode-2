/**
 * Created on 2 Oct 2018 by happygirlzt
 *
 * LeetCode 72. Edit Distance
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int a = dp[i][j];
                    int b = dp[i][j+1];
                    int c = dp[i+1][j];
                    dp[i+1][j+1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    dp[i+1][j+1]++;
                }
            }
        }

        return dp[n][m];
    }
}
