/**
 * Created on 7 Apr 2019 by happygirlzt
 *
 * LeetCode #1011. Capacity To Ship Packages Within D Days
 *
 */

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int max = 0;
        int sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        int lo = max;
        int hi = sum;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int num = split(weights, mid);
            if (num > D) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private int split(int[] weights, int validMaxCapacity) {
        int sum = 0;
        int count = 1;
        for (int w : weights) {
            if (sum + w > validMaxCapacity) {
                sum = w;
                count++;
            } else {
                sum += w;
            }
        }

        return count;
    }
}
