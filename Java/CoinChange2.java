/**
 * Created on 17 Oct 2018 by happygirlzt
 *
 * LeetCode #518. Coin Change 2
 *
 * 
 * You are given coins of different denominations
 *  and a total amount of money. Write a function
 *  to compute the number of combinations that
 *  make up that amount. You may assume that
 *  you have infinite number of each kind of coin.
 */
public class CoinChange2 {
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
}
