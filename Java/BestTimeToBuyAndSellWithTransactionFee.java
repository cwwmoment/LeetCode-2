/**
 * Created on 8 Mar 2019 by happygirlzt
 *
 * LeetCode #714. Best Time to Buy and Sell Stock with Transaction Fee
 *
 */

// 每一天有两种情况，手上有stock，手上没有
// 如果第一天手上有stock，就是买了，-prices[0]
// hold means the max profit if we buy stock that day
// cash means the max profit if we sell stock that day
// at last, we cannot have a stock, so we return cash
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
