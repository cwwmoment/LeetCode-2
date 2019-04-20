/**
 * Created on 1 Jan 2019 by happygirlzt
 *
 * LeetCode #926. Flip String to Monotone Increasing
 *
 */

// 这题要求求出最少的翻转数，使得0都在左边，1都在右边。
// 这种求最优解的一般使用动态规划。
// dp[i][0] 表示当前是0，需要反转的1的数量
// dp[i][1] 表示当前是1，需要反转的0的数量
class Solution {
    // Updated on 20 Apr 2019
    // O(N), O(1)
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() == 0) return 0;

        int zeroes = 0, ones = 0;
        int flip = 0;

        for (char c : S.toCharArray()) {
            if (c == '0') {
                if (ones != 0) {
                    flip++;
                } else continue;
            } else {
                ones++;
            }

            if (flip > ones) {
                flip = ones;
            }
        }

        return flip;
    }

    public int minFlipsMonoIncr(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '1') {
                dp[i + 1][1] = Math.min(dp[i][1], dp[i][0]);
                dp[i + 1][0] = dp[i][0] + 1;
            } else {
                dp[i + 1][1] = dp[i][1] + 1;
                dp[i + 1][0] = dp[i][0];
            }
        }

        return Math.min(dp[n][0], dp[n][1]);
    }

    // Solution 2
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() == 0) return 0;
        char[] cs = S.toCharArray();
        int ones = 0, res = 0;

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                if (ones == 0) {
                    continue;
                } else {
                    res++;
                }
            } else {
                ones++;
            }

            res = Math.min(ones, res);
        }

        return res;
    }
}
