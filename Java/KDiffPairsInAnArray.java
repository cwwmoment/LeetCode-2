/**
 * Created on 6 May 2019 by happygirlzt
 *
 * LeetCode #532. K-diff Pairs in an Array
 *
 */

class Solution {
    public int findPairs(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = Math.abs(nums[j] - nums[i]);
                if (diff != k) continue;
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                sb.append("#");
                sb.append(nums[j]);
                set.add(sb.toString());
            }
        }

        return set.size();
    }

    // binary search
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            if (Arrays.binarySearch(nums, i + 1, nums.length, nums[i] + k) > 0) {
                res++;
            }
        }

        return res;
    }
}
