/**
 * Created on 17 Sep 2018 by happygirlzt
 *
 * LeetCode #121. Best Time to Buy and Sell Stock
 */

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        int min = prices[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(prices[i] - min, dp[i - 1]);
            min = Math.min(min, prices[i]);
        }

        return dp[len - 1];
    }
}
