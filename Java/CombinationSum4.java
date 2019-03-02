/**
 * Created on 12 Feb 2019 by happygirlzt
 *
 * LeetCode #377. Combination Sum IV
 */

class Solution {
    // This problem is actually permutation.
    // Compared to Coin Change 2 problem.
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
