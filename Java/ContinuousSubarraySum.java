/**
 * Created on 21 Jan 2019 by happygirlzt
 *
 * LeetCode #523. Continuous Subarray Sum
 *
 */

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }

    // Updated on 5 Mar 2019
    // 要想清楚怎么处理0，e.g. [0, 0] 0
    public boolean checkSubarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) return true;
            }
            map.putIfAbsent(sum, i);
        }

        return false;
    }
}
