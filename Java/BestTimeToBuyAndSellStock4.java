/**
 * Created on 17 Nov 2018 by happygirlzt
 *
 * Modified on 4 Dec 2018
 *
 * LeetCode #188. Best Time to Buy and Sell Stock IV
 *
 */
// Avoid TLE
public class BestTimeToBuyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length < 2) return 0;
        int len = prices.length;
        if (k >= len / 2) k = len / 2;
        int[] dp = new int[len + 1];

        for (int i = 1; i <= k && i < len; i++) {
            int tmp = dp[1] - prices[0];
            for (int j = 1; j <= len; j++) {
                int pre = dp[j];
                dp[j] = Math.max(dp[j - 1], Math.max(dp[j], prices[j - 1] + tmp));
                tmp = Math.max(tmp, pre - prices[j - 1]);
            }
        }

        return dp[len];
    }
}
