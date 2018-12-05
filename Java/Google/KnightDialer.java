/**
 * Created on 5 Dec 2018 by happygirlzt
 *
 * LeetCode #935. Knight Dialer
 *
 */

public class KnightDialer {
    private final int MOD = 1_000_000_007;
    private final int[][] moves = {{4, 6}, {6, 8}, {7, 9}, {4, 8},
                                   {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    private int[][] dp = new int[5001][10];

    public int knightDialer(int N) {
        int res = 0;

        for (int i = 0;  i < 10; i++) {
            res = (res + helper(N, i)) % MOD;
        }

        return res;
    }

    public int helper(int N, int digit) {
        if (N == 1) return 1;
        if (digit == 5) return 0;

        if (dp[N][digit] > 0) return dp[N][digit];

        for (int next : moves[digit]) {
            dp[N][digit] = (dp[N][digit] + helper(N - 1, next)) % MOD;
        }

        return dp[N][digit];
    }
}
