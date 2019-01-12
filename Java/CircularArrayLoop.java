/**
 * Created on 12 Jan 2019 by happygirlzt
 *
 * LeetCode #457. Circular Array Loop
 *
 */

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        return sum > nums.length;
    }
}
