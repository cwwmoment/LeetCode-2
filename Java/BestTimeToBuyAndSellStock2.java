/**
 * Created on 18 Oct 2018 by happygirlzt
 *
 * LeetCode #122. Best Time to Buy and Sell Stock II
 *
 */

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = -1;
        boolean hold = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                if (hold == false) {
                    hold = true;
                    buy = prices[i];
                } else {
                    continue;
                }
            } else if (prices[i] > prices[i + 1]) {
                if (hold) {
                    res += prices[i] - buy;
                    hold = false;
                } else {
                    continue;
                }
            }
        }

        if (hold == true && prices[prices.length - 1] > buy) {
            res += prices[prices.length - 1] - buy;
        }

        return res;
    }
}
