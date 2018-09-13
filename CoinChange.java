import java.util.Arrays;

/**
 * Created by happygirlzt on 10 Sep 2018
 *
 * LeetCode #322. Coin Change
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        int[] dp = new int[amount];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}

public static void main(String[] args) {
    int[] nums = { 186, 419, 83, 408 };
    int amount = 6249;
    System.out.println(coinChange(nums, amount));
}
}
