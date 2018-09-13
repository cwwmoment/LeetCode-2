/**
 * LeetCode #279. Perfect Squares
 *
 * Created on 13 Sep 2018 by happygirlzt
 */

/*
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * This problem is like the combination of coin change and valid perfect squares 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PerfectSquares {
	public static int numSquares(int n) {
		List<Integer> sqs = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (isSquare(i)) {
				sqs.add(i);
			}
		}

		// System.out.println(sqs);
		int[] dp = new int[n + 1];	
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		
		for (Integer s : sqs) {
			for (int j = s; j <= n; j++) {
				dp[j] = Math.min(dp[j], dp[j - s] + 1);
				// System.out.println("dp[" + j + "] = " + dp[j]);
			}
		}

		return dp[n] == Integer.MAX_VALUE - 1 ? n : dp[n];
	}

	public static boolean isSquare(int num) {
		int left = 0, right = num;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid * mid == num || left * left == num || right * right == num) {
				return true;
			} else if (mid * mid > num) {
				right = mid - 1;
			} else if (mid * mid < num) {
				left = mid + 1;
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		int n = 12;
		System.out.println(numSquares(n));
	}
}
