/**
 * Created on 1 Feb 2019 by happygirlzt
 *
 * LeetCode #674. Longest Continuous Increasing Subsequence
 *
 */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 1; dp[1] = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = (nums[i] > nums[i - 1]) ? dp[i] + 1 : 1;
            maxLength = Math.max(maxLength, dp[i + 1]);
        }

        return maxLength;
    }

    // Solution 1: Space Complexity O(1)
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) start = i;
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
