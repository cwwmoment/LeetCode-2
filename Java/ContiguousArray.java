/**
 * Created on 2 Feb 2019 by happygirlzt
 *
 * LeetCode #525. Contiguous Array
 *
 */

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0, maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
