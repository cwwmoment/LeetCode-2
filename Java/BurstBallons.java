/**
 * Created on 29 Oct 2018 by happygirlzt
 *
 * LeetCode #312. Burst Balloons
 *
 */

// 主要是找到递推式
// dp[i][j] 表示打爆[i, j]中所有气球所能得到的最多金币
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int[] n = new int[len + 2];
        n[0] = 1;
        n[len + 1] = 1;

        int idx = 1;
        for (int i : nums) {
            n[idx++] = i;
        }

        int[][] dp = new int[len + 2][len + 2];

        for (int i = 1; i <= len; i++) {
            for (int left = 1; left <= len - i + 1; left++) {
                int right = i + left - 1;
                for (int k = left; k <= right; k++)
                    dp[left][right] = Math.max(dp[left][right], n[left - 1] * n[k] * n[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
            }
        }

        return dp[1][len];
    }
}
