/**
 * Created on 17 Oct 2018 by happygirlzt
 *
 * LeetCode #416. Partition Equal Subset Sum
 *
 */

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res += i;
        }

        boolean[] dp = new boolean[res + 1]; // 用boolean类型我也没想出来
        dp[0] = true;

        if (res % 2 != 0) return false;

        res /= 2;  // 这点我没想出来。。
        for (int num : nums) {
            for (int j = res; j > 0; j--) {
                if (j >= num) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }
        return dp[res];
    }
}
