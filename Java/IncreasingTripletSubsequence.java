/**
 * Created on 2 Jan 2019 by happygirlzt
 *
 * LeetCode #334. Increasing Triplet Subsequence
 *
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, large = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= small) {
                small = nums[i];
            } else if (nums[i] <= large) {
                large = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}
