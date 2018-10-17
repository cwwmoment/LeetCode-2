/**
 * LeetCode 198. House Robber
 * 
 * Created by happygirlzt on 9 Sep 2018 at 4:34:37 PM
 *
 */
public class HouseRobber {
	public int rob(int[] nums) {
		if (nums.length == 0 || nums == null) return 0;
		int len = nums.length;
		if (len == 1) return nums[0];
		int[] dp = new int[len + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		dp[2] = Math.max(dp[1], nums[1]);
		if (len == 2) {
			return dp[2];
		}
		for (int i = 3; i <= len; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}
		
		return dp[len];
	}
}
