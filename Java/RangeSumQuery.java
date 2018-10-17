/**
 * LeetCode #303. Range Sum Query - Immutable
 *
 * Created by happygirlzt on 9 Sep 2018 at 8:04:29 PM
 *
 */
public class RangeSumQuery {
    static class NumArray {
        private static int[] dp;

        public NumArray(int[] nums) {
            int len = nums.length;
            dp = new int[len + 1];

            dp[0] = 0;
            for (int i = 1; i <= len; i++) {
                dp[i] = dp[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return dp[j + 1];
            } else if (i > 0) {
                return dp[j + 1] - dp[i];
            } else {
                return -1;
            }
        }
    }
}
