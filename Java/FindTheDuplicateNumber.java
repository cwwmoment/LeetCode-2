/**
 * Created on 30 Jan 2019 by happygirlzt
 *
 * LeetCode #287. Find the Duplicate Number
 *
 */

class Solution {
    // Solution 0: Swap, which is not permitted
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                } else {
                    swap(nums, i, nums[i] - 1);
                }
            }
        }

        return nums[nums.length - 1];
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // Solution 1: Use the idea of find cycles in Linked List
    public int findDuplicates1(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
