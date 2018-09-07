/**
 * 
 * Created by happygirlzt on 7 Sep 2018 at 7:10:35 PM
 *
 */
public class MaximumSubarray {
	// TLE solution
	public int maxSubnumsrray(int[] nums) {
		if (nums.length == 0)
			return 0;
		int len = nums.length;
		int[][] dp = new int[len + 1][len + 1];

		for (int i = 0; i < len; i++) {
			dp[i][i] = nums[i];
			dp[i][len] = nums[i]; // default
		}

		for (int i = 0; i < len; i++) {
			for (int j = i; j < len - 1; j++) {
				if (nums[j + 1] >= 0) {
					dp[i][j + 1] = dp[i][j] + nums[j + 1];
				} else {
					dp[i][len] = dp[i][j];
					break;
				}			   
			}
		}

		int res = dp[0][len];
		for (int k = 0; k < len; k++) {
			res = Math.max(dp[k][len], res);
		}

		return res;
	}
	
	public int maxSubnumsrray1(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		int max = dp[0];
		
		for (int i = 0; i < nums.length; i++) {
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(dp[i], max);
		}
		
		return max;
	}
}
