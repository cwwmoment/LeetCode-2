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

     // Updated on 18 Mar
     public int longestLine1(int[][] M) {
         if (M == null || M.length == 0) return 0;
         int max = 0;
         int m = M.length, n = M[0].length;
         int[] row = new int[m];
         int[] col = new int[n];
         int[] diag = new int[m + n];
         int[] adiag = new int[m + n];

         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (M[i][j] == 1) {
                     row[i]++;
                     col[j]++;
                     diag[i + j]++;
                     adiag[j - i + m]++;
                     max = Math.max(max, Math.max(row[i], col[j]));
                     max = Math.max(max, Math.max(diag[i + j], adiag[j - i + m]));
                 } else {
                     row[i] = 0;
                     col[j] = 0;
                     diag[i + j] = 0;
                     adiag[j - i + m] = 0;
                 }
             }
         }

         return max;
     }
}
