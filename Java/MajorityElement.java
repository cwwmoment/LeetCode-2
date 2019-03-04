/**
 * Created on 4 Mar 2019 by happygirlzt
 *
 * LeetCode #169. Majority Element
 *
 */

class Solution {
    // Time: O(N), Space: O(N)
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) return num;
        }

        return -1;
    }

    // Time: O(N), Space: O(1)
    // Boyer-Moore Voting Algorithm
    public int majorityElement1(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count = (candidate == num) ? count + 1 : count - 1;
        }

        return candidate;
    }
}
