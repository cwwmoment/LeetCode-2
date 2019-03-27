/**
 * Created on 4 Oct 2018 by happygirlzt
 *
 * LeetCode #746. Min Cost Climbing Stairs
 */

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        int len = cost.length;
        if (len == 0) return dp[0];

        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i+1] = Math.min(dp[i] + cost[i], dp[i - 1] + cost[i - 1]);
        }

        return dp[len];
    }
}
