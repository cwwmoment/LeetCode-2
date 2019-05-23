/**
 * Created on 23 May 2019 by happygirlzt
 *
 * LeetCode #1029. Two City Scheduling
 *
 */

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - (b[0] - b[1]));

        int res = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }

        return res;
    }
}
