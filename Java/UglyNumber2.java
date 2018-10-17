/**
 * Created on 13 Oct 2018 by happygirlzt
 *
 * LeetCode #264. Ugly Number II
 */

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];

        dp[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;
        int fact2 = 2, fact3 = 3, fact5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(fact2, fact3), fact5);
            dp[i] = min;
            if (fact2 == min) {
                fact2 = 2 * dp[++index2];
            }
            if (fact3 == min) {
                fact3 = 3 * dp[++index3];
            }
            if (fact5 == min) {
                fact5 = 5 * dp[++index5];
            }
        }

        return dp[n - 1];
    }
}
