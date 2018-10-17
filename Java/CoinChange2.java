/**
 * Created on 17 Oct 2018 by happygirlzt
 *
 * LeetCode #518. Coin Change 2
 *
 */
public class CoinChange2 {
    // solution 1
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    // solution 2
    public int change2(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        Arrays.fill(dp[0], 0);

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = 0;
                for (int k = 0; k * coins[i - 1] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
