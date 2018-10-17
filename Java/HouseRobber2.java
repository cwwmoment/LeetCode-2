/**
 * LeetCode #213. House Robber II
 * 
 * Created by happygirlzt on 9 Sep 2018 at 4:59:43 PM
 *
 */
public class HouseRobber2 {
	public static int rob(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int len = nums.length;
		int[] dp = new int[len + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		if (len == 1)
			return dp[1];
		boolean flag = false;

		dp[2] = Math.max(nums[0], nums[1]);
		if (dp[2] == nums[0])
			flag = true;

		if (len == 2)
			return dp[2];

		if (len == 3)
			return Math.max(dp[2], nums[2]);
		
		for (int i = 3; i <= len; i++) {
			if (dp[i - 1] < dp[i - 2] + nums[i - 1]) {
				dp[i] = dp[i - 2] + nums[i - 1];
				if (i == 3) flag = true;
				if (i == 4 && dp[2] <= nums[1]) flag = false;
			} else {
				dp[i] = dp[i - 1];
			}
		}

		if (flag == true) {
			dp[len] = Math.max(dp[len - 1], dp[len - 2] + nums[len - 1] - nums[0]);
		} else {
			dp[len] = Math.max(dp[len - 1], dp[len - 2] + nums[len - 1]); 
			System.out.println("He");
		}
		return dp[len];
	}

	public static void main(String[] args) {
		 // int[] nums = {1,1,1,2};
		// int[] nums = {1, 3, 1, 3, 100};
		// int[] nums = {4,1,2,7,5,3,1};
		// int[] nums = {2,3,2};
		//int[] nums = {1,2,3,1};
		// int[] nums = {2,1,1,2};
		// int[] nums = {1, 1, 1, 1, 5, 1};
		int[] nums = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
		System.out.println(rob(nums));
	}
}
