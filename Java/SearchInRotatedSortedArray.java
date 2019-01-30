/**
 * Created by happygirlzt
 *
 * LeetCode #33. Search in Rotated Sorted Array
 */

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else {
                if (i != nums.length - 1) {
                    continue;
                } else {
                    return -1;
                }
            }
        }

        return -1;
    }

    // Modified on 21 Dec 2018
    // Binary Search
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    // Updated on 30 Jan 2019
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {  // take care of this =
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[lo] <= nums[mid]) { // take care of this =
                if (nums[mid] < target || nums[lo] > target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[hi]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }
}
