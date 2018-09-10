import java.util.Arrays;

/**
 * Created by happygirlzt on 10 Sep 2018
 *
 * LeetCode #322. Coin Change
 */

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int len = coins.length;
		int[] dp = new int[len + 1];
		dp[0] = 0;
		
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 186, 419, 83, 408 };
		int amount = 6249;
		System.out.println(coinChange(nums, amount));
	}
}
