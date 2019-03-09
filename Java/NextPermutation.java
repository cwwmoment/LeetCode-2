/**
 * Created on 14 Sep 2018 by happygirlzt
 *
 * LeetCode #31. Next Permutation
 */
/*  Modified on 5 Feb 2019
 *  Step 0: find the num prev(pos is p) that is break the decending order from right to left
 *  Step 1: if not found, reverse the whole array, such like: 3, 2, 1
 *          if found, start from the right to find the first element greater than prev; reverse the array on the right of p
 * Time complexity: O(n)
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int len = nums.length;
        int tmp = -1, prev = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                tmp = i;
                prev = nums[i];
                break;
            }
        }

        if (tmp == -1) {
            reverse(nums, 0, len - 1);
            return;
        }

        for (int i = len; i >= 0; i--) {
            if (nums[i] > prev) {
                swap(nums, tmp, i);
                break;
            }
        }

        reverse(nums, tmp + 1, len - 1);
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Updated on 9 Mar 2019
    // May have duplicates
    public void nextPermutation(int[] nums) {
        // find the first pair that the preceding element is less than the following one
        // 1 2 3
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 3 2 1
        // Find the first element, which is greater the nums[i]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // swap them
            swap(nums, i, j);
        }

        // reverse
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
