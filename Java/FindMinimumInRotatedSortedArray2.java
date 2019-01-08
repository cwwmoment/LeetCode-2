/**
 * Created on 8 Jan 2019 by happygirlzt
 *
 * LeetCode #154. Find Minimum in Rotated Sorted Array II
 *
 */

class Solution {
    public int findMin(int[] a) {
        int lo = 0, hi = a.length - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[hi] < a[mid]) {
                lo = mid + 1;
            } else if (a[mid] < a[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }

        return a[lo];
    }
}
