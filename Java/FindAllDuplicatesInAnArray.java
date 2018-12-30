/**
 * Created on 30 Dec 2018 by happygirlzt
 *
 * LeetCode #442. Find All Duplicates in an Array
 *
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(nums[i]));
            }

            nums[index] = -nums[index];
        }
        return res;
    }
}
