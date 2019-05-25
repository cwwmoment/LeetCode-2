/**
 * Created on 25 May 2019 by happygirlzt
 *
 * LeetCode #453. Minimum Moves to Equal Array Elements
 *
 */

class Solution {
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }

        return moves - min * nums.length;
    }
}
