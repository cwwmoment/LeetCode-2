/**
 * Created on 9 Apr 2019 by happygirlzt
 *
 * LeetCode #853. Car Fleet
 *
 */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        int[] bucket = new int[target];
        int n = position.length;

        for (int i = 0; i < n; i++) {
            bucket[position[i]] = speed[i];
        }

        double cur = 0;
        for (int k = bucket.length - 1; k >= 0; k--) {
            if (bucket[k] != 0) {
                double time = (double) (target - k) / bucket[k];

                if (time > cur) {
                    res ++;
                    cur = time;
                }
            }
        }

        return res;
    }
}
