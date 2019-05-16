/**
 * Created on 16 May 2019 by happygirlzt
 *
 * LeetCode #747. Largest Number At Least Twice of Others
 *
 */

class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) return 0;

        int first = -1, second = -1;
        for (int i = 0; i < nums.length; i++) {
            if (first == -1 || nums[i] > nums[first]) {
                second = first;
                first = i;
            } else if (second == -1 || nums[i] < nums[first] && nums[i] > nums[second]) {
                second = i;
            }
        }

        if (nums[first] >= 2 * nums[second] && first != second) {
            return first;
        }
        return -1;
    }
}
