/**
 * Created on 18 Oct 2018 by happygirlzt
 *
 * LeetCode #123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

public class BestTimeToBuyAndSellStock3 {
    // 两个dp，left[i]表示从第一天到第i天进行一次交易的最大收益
    // right[i]表示从第i天到最后一天进行一次交易的最大的收益
    // 最后循环一次，得到最大值
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int[] dp = new int[prices.length + 1];
        dp[0] = 0;

        int size = prices.length;
        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < size; i++) {
            minPrice = Math.min(prices[i], minPrice);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }

        right[size - 1] = 0;
        int maxPrice = prices[size - 1];
        for (int i = size - 2; i > 0; i--) {
            maxPrice = Math.max(prices[i], maxPrice);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }

        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            profit = Math.max(left[i] + right[i], profit);
        }

        return profit;
    }
}
