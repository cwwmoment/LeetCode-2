/**
 * Created on 3 Mar 2019 by happygirlzt
 *
 * LeetCode #153. Find Minimum in Rotated Sorted Array
 *
 */

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int lo = 0;
        int hi = nums.length - 1;

        if (nums[hi] > nums[0]) return nums[0];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    // Updated on 4 Mar 2019
    public int findMin1(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums[hi] > nums[lo]) return nums[lo];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];

            if (nums[mid] > nums[lo]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return nums[hi];
    }
}
