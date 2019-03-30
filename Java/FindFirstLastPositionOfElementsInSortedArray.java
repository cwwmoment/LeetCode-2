/*
 * LeetCode #34. Find First and Last Position of Element in Sorted Array
 * happygirlzt
 * Created on 17 Aug 2018
 */
public class FindFirstLastPositionOfElementsInSortedArray {

    // Naive Solution
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        if (nums.length == 1 && nums[0] == target) {
            return new int[] { 0, 0 };
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] { -1, -1 };
        }

        int i = 0, j = nums.length - 1;
        int m = -1, n = -1;
        boolean flagI = false, flagJ = false;
        while (i <= j) {
            if (nums[i] < target) {
                i++;
            } else if (nums[i] == target) {
                m = i;
                flagI = true;
            }

            if (nums[j] > target) {
                j--;
            } else if (nums[j] == target) {
                n = j;
                flagJ = true;
            }

            if (flagI && flagJ) {
                break;
            }
        }

        return new int[] { m, n };
    }

    // Binary Search
    public static int[] searchRange1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right + 1) / 2;

            if (nums[mid] == target) {
                if (nums[left] == target && nums[right] == target) {
                    return new int[]{left, right};
                } else if (nums[left] != target) {
                    left ++;
                } else if (nums[right] != target) {
                    right --;
                }

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    // Updated on 1 Feb 2019
    // Two pass binary search
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target) {
        int index = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) { // pay attention >=
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }

    private int findLast(int[] nums, int target) {
        int index = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }

    // Updated on 30 Mar 2019

}
