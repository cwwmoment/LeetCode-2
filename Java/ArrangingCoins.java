/**
 * Created on 21 Nov 2018 by happygirlzt
 *
 * LeetCode #441. Arranging Coins
 *
 */

// Pay attention to Integer.MAX_VALUE, so use Long
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n == 0) return 0;
        long mid;

        if (n == Integer.MAX_VALUE) {
            mid = n >> 1;
        } else {
            mid = (1 + n) >> 1;
        }

        long sum = 0, res = 1;

        for (int i = 1; i <= mid; i++) {
            sum += i;

            if (sum <= n) {
                res = i;
            } else {
                break;
            }
        }

        return (int) res;
    }
}
