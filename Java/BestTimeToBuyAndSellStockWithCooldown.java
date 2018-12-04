/**
 * Created ob 25 Sep 2018 by happygirlzt
 *
 * Modified on 4 Dec 2018
 *
 * LeetCode #309. Best Time to Buy and Sell Stock with Cooldown
 */

// 看了一个大佬的解答，好强！
// s0表示这一天cooldown，s1表示这一天buy，s2表示这一天sell
// 最后的最大收益是，最后一天cooldown或者sell
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[] s0 = new int[len];
        int[] s1 = new int[len];
        int[] s2 = new int[len];

        // base case
        s0[0] = 0;
        s1[0] = -prices[0];  // Buy, so profit decreases
        s2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }

        return Math.max(s0[len - 1], s2[len - 1]);
    }
}
