/*
 * Created on 4 Dec 2018 by happygirlzt
 *
 * LeetCode #683. K Empty Slots
 *
 */

public class KEmptySlots {
    // Updated on 31 Mar 2019, Sliding Window
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        int[] position = new int[n + 1];
        for (int i = 0; i < n; i++) {
            position[flowers[i]] = i;
        }

        int res = Integer.MAX_VALUE;
        int lo = 1, hi = 2 + k;
        for (int i = 1; hi <= n; i++) {
            if (position[i] > position[lo] &&
                position[i] > position[hi]) continue;

            if (i == hi) {
                res = Math.min(res, Math.max(position[lo], position[hi]) + 1);
            }

            lo = i;
            hi = i + k + 1;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
