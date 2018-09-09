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
	
	public int maxSubArray1(int[] nums) {
		if (nums.length == 0 || nums == null) return 0;
		int len = nums.length;
		int[] b = new int[len];
		b[0] = nums[0];
		int res = b[0];
		for (int i = 1; i < len; i++) {
			if (nums[i] + b[i - 1] > nums[i]) {
				b[i] = nums[i] + b[i - 1];
			} else {
				b[i] = nums[i];
			}
			res = Math.max(b[i], res);
		}
		
		return res;
	}
}
