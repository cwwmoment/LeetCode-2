/**
 * Created on 2 Jan 2019 by happygirlzt
 *
 * LeetCode #334. Increasing Triplet Subsequence
 *
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Time: O(N), Space: O(1)

        // Pay attention that these two are both MAX_VALUE
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= smallest) {
                smallest = i;
            } else if (i <= largest) {
                largest = i;
            } else {
                return true;
            }
        }

        return false;
    }
}
