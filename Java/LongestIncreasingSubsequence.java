/**
 * LeetCode #300. Longest Increasing Subsequence
 *
 * Created by happygirlzt on 10 Sep 2018 at 3:27:21 PM
 *
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;

        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // Updated on 27 Feb 2019
    // Use TreeMap, O(NlogN)
    public int lengthOfLIS1(int[] nums) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int maxLen = 0;

        for (int n : nums) {
            if (tmap.isEmpty()) {
                tmap.put(n, 1);
                maxLen = 1;
            } else {
                Integer ceiling = tmap.ceilingKey(n);
                if (ceiling == null) {
                    maxLen++;
                    tmap.put(n, maxLen);
                } else {
                    int ceilingLen = tmap.get(ceiling);
                    tmap.remove(ceiling);
                    tmap.put(n, ceilingLen);
                }
            }
        }

        return maxLen;
    }

    // DP, O(N^2)
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            int maxPre = 0;
            for (int pre = 0; pre < i; pre++) {
                if (nums[i] > nums[pre]) {
                    maxPre = Math.max(maxPre, dp[pre]);
                }
            }

            dp[i] = maxPre + 1;
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }
}
