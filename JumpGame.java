/**
 * LeetCode #55. Jump Game
 *
 * Created on 13 Sep 2018 by happygirlzt
 */

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums == null) return true;

        int len = nums.length - 1;

        int start = 0;
        for (int i = start; i < nums.length - 1; i++) {
            for (int j = nums[i]; j > 0; j--) {
                if (len >= j) {
                    len -= j;
                    start = j;

                    if (len == 0) return true;
                    break;
                }
            }
        }

        return false;
    }
}
