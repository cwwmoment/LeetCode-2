/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #485. Max Consecutive Ones
 *
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int tmp = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                tmp++;
                res = Math.max(res, tmp);
            } else {
                tmp = 0;
            }
            i++;
        }

        return res;
    }
}
