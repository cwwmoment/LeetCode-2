/**
 * Created on 5 Dec 2018 by happygirlzt
 *
 * LeetCode #135. Candy
 *
 */

public class Candy {
    public int candy(int[] r) {
        int[] candies = new int[r.length];

        Arrays.fill(candies, 1);

        // scan from left
        for (int i = 1; i < r.length; i++) {
            if (r[i] > r[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // scan from right
        for (int i = r.length - 2; i >= 0; i--) {
            if (r[i] > r[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }

        int res = 0;
        for (int i : candies) {
            res += i;
        }

        return res;
    }
}
