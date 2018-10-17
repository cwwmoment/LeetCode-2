/**
 * LeetCode #70. Climbing Stairs
 * 
 * Created by happygirlzt on 9 Sep 2018 at 4:03:32 PM
 *
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		// Base case
		if (n == 1) return 1;
		if (n == 2) return 2;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
	
	public int climbStairs2(int n) {
		if (n == 0 || n == 1 || n == 2) return n;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
 		}
		
		return dp[n];
	}
}
