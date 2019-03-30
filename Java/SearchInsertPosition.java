/**
 * Updated on 30 Mar 2019 by happygirlzt
 *
 * LeetCode #35. Search Insert Position
 *
 */

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        if (target < nums[0]) return 0;
        if (target == nums[0]) return 0;

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while (target != nums[mid]) {
            if (target < nums[mid]) {
                if (left + 1 == mid) {
                    return mid;
                } else {
                    right = mid;
                    mid = (left + right) / 2;
                }
            } else {
                if (mid + 1 == right) {
                    return mid + 1;
                } else {
                    left = mid;
                    mid = (left + right) / 2;
                }
            }
        }

        return mid;
    }

    // Better Version
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
