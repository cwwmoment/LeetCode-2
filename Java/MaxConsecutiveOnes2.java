/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #487. Max Consecutive Ones II
 *
 */

// Sliding window
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, zero = 0, k = 1;

        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                zero++;
            }

            while (zero > k) {
                if (nums[l++] == 0) {
                    zero--;
                }
            }

            res = Math.max(res, h - l + 1);
        }

        return res;
    }
}
