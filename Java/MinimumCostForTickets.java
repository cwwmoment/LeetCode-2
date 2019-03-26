/**
 * Created on 26 Mar 2019 by happygirlzt
 *
 * LeetCode #983. Minimum Cost For Tickets
 *
 */

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] isTravelDay = new boolean[366];
        for (int day: days) {
            isTravelDay[day] = true;
        }

        int[] dp = new int[366];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < 366; i++) {
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
            if (i - 7 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
            } else {
                dp[i] = Math.min(dp[i], costs[1]);
            }

            if (i - 30 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
            } else {
                dp[i] = Math.min(dp[i], costs[2]);
            }
        }

        return dp[365];
    }
}
