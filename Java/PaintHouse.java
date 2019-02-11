/**
 * Created on 16 Dec 2018 by happygirlzt
 *
 * LeetCode #256. Paint House
 *
 */

class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length + 1][3];

        for (int i = 0; i < costs.length; i++) {
            dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]) + costs[i][0];
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][2]) + costs[i][1];
            dp[i + 1][2] = Math.min(dp[i][0], dp[i][1]) + costs[i][2];
        }

        return Math.min(Math.min(dp[costs.length][0], dp[costs.length][1]), dp[costs.length][2]);
    }
}
