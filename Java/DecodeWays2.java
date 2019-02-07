/**
 * Created on 7 Feb 2019 by happygirlzt
 *
 * LeetCode #639. Decode Ways II
 *
 */

class Solution {
    private int M = 1000000007;
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (s.charAt(i - 1) == '1') {
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                } else if (s.charAt(i - 1) == '2') {
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                } else if (s.charAt(i - 1) == '*') {
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
                }
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1') {
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                } else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                } else if (s.charAt(i - 1) == '*') {
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
                }
            }
        }

        return (int) (dp[s.length()]);
    }
}
