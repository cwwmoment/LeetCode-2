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

    public static void main(String[] args) {
        int[] a = {1};
        int[] res = searchRange1(a, 1);

        for (int i : res) {
            System.out.println(i);
        }
    }
}
