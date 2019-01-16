/**
 * Create on 16 Jan 2019 by happygirlzt
 *
 * LeetCode #81. Search in Rotated Sorted Array II
 *
 */

class Solution {
    public boolean search(int[] a, int target) {
        int lo = 0, hi = a.length - 1, mid = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] == target) {
                return true;
            }

            if (a[mid] < a[hi] || a[mid] < a[lo]) {
                if (target > a[mid] && target <= a[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else if (a[mid] > a[lo] || a[mid] > a[hi]) {
                if (target < a[mid] && target >= a[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi--;
            }
        }

        return false;
    }
}
