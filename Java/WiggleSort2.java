/**
 * LeetCode #324. Wiggle Sort II
 *
 * Created on 14 Sep 2018 by happygirlzt
 */

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = m - 1, j = 0; i >= 0; j += 2) {
            nums[j] = copy[i--];
        }

        for (int i = n - 1, j = 1; i >= m; j += 2) {
            nums[j] = copy[i--];
        }
    }
}
