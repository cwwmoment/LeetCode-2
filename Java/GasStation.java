/**
 * Created on 17 Apr 2019 by happygirlzt
 *
 * LeetCode #134. Gas Station
 *
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total = 0;
        int cur = 0;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];

            if (cur < 0) {
                startIndex = i + 1;
                cur = 0;
            }
        }

        return total >= 0 ? startIndex : -1;
    }
}
