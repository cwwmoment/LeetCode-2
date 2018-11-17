/**
 * Created on 17 Sep 2018 by happygirlzt
 *
 * LeetCode #121. Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
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
