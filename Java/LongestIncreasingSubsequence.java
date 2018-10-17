/**
 * LeetCode #300. Longest Increasing Subsequence
 * 
 * Created by happygirlzt on 10 Sep 2018 at 3:27:21 PM
 *
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = 0;
		
		// initiative
		for (int i = 1; i < len; i++) {
			dp[i] = 1;
		}
		
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int res = dp[0];
		for (int i = 0; i < len; i++) {
			res = Math.max(res, dp[i]);
		}
		
		return res;
	}
}
