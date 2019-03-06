/**
 * Created on 6 Mar 2019 by happygirlzt
 *
 * LeetCode #918. Maximum Sum Circular Subarray
 *
 */

// Core idea:
// The maximum subarray has two cases:
// 0. in the middle of the array
//      => just find the maximum subarray is ok
// 1. in the first part and the end part
//      => find the minimum subarray in the middle,
//      use sum - minimum
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) return 0;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndHere = 0;
        int sum = 0;
        for (int num : A) {
            maxEndHere += num;
            if (maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
            }

            if (maxEndHere < 0) {
                maxEndHere = 0;
            }

            sum += num;
        }

        int minSoFar = Integer.MAX_VALUE;
        int minEndHere = 0;
        for (int num : A) {
            minEndHere += num;
            if (minSoFar > minEndHere) {
                minSoFar = minEndHere;
            }

            if (minEndHere > 0) {
                minEndHere = 0;
            }
        }

        // With all negative numbers, just return the maxSoFar
        return maxSoFar > 0 ? Math.max(maxSoFar, sum - minSoFar) : maxSoFar;
    }
}
