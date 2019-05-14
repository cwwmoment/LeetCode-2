/**
 * Created on 29 Oct 2018 by happygirlzt
 * Updated on 14 May 2019
 *
 * LeetCode #312. Burst Balloons
 *
 */

// 主要是找到递推式
// dp[i][j] 表示打爆[i, j]中所有气球所能得到的最多金币
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int len = n + 2;
            int[] a = new int[len];
            System.arraycopy(nums, 0, a, 1, n);
            a[0] = 1;
            a[len - 1] = 1;
            int[][] dp = new int[len][len];
            // dp[i][j] = max coins i ~ j
            for (int gap = 2; gap < len; gap++) {
                for (int left = 0; left < len - gap; left++) {
                    int right = left + gap;
                    int cur = 0;
                    for (int i = left + 1; i < right; i++) {
                        cur = Math.max(cur, dp[left][i] + dp[i][right] + a[i] * a[left] * a[right]);
                    }

                    dp[left][right] = cur;
                }
            }

            return dp[0][len - 1];
        }
    }
}
