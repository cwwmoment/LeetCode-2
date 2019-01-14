/**
 * Created on 14 Jan 2019 by happygirlzt
 *
 * LeetCode #209. Minimum Size Subarray Sum
 *
 */

class Solution {
    // O(n), two pointers
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int lo = 0, sum = 0;
        for (int hi = 0; hi < nums.length; hi++) {
            sum += nums[hi];

            while (sum >= s) {
                res = Math.min(res, hi - lo + 1);
                sum -= nums[lo++];
            }
        }

        return res != Integer.MAX_VALUE ? res : 0;
    }
}
