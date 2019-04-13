/**
 * Created on 13 Apr 2019 by happygirlzt
 *
 * LeetCode #1004. Max Consecutive Ones III
 *
 */

class Solution {
    // My Slow Sliding Window Solution
    public int longestOnes(int[] A, int K) {
        int lo = 0, hi = 0;
        int max = 0;
        int count = 0;
        for (; hi < A.length; hi++) {
            if (A[hi] == 0) {
                count++;
            }
            while (hi + 1 < A.length && A[hi + 1] == 1) {
                hi++;
            }

            while (count > K) {
                while (lo < hi && A[lo] == 1) {
                    lo++;
                }
                lo++;
                count--;
            }

            if (count <= K) {
                max = Math.max(max, hi - lo + 1);
            }
        }

        return max;
    }

    // Other's fast solution
    public int longestOnes(int[] A, int K) {
        int lo = 0;
        int hi = 0;
        for (; hi < A.length; hi++) {
            K -= 1 - A[hi];

            if (K < 0) {
                K += 1 - A[lo];
                lo++;
            }
        }

        return hi - lo;
    }
}
