/**
 * Created on 8 Apr 2019 by happygirlzt
 *
 * LeetCode #875. Koko Eating Bananas
 *
 */

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0, n = piles.length;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (piles[i] > max) {
                max = piles[i];
                sum += piles[i];
            }
        }

        if (sum < H) return 1;

        int lo = 0, hi = max;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int hours = getHours(piles, mid);
            if (hours > H) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int getHours(int[] piles, int target) {
        int cnt = 0;
        for (int i = 0; i < piles.length; i++) {
            cnt += (piles[i] - 1) / target + 1;
        }
        return cnt;
    }
}
