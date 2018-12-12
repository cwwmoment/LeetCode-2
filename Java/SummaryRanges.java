/**
 * Created on 12 Dec 2018 by happygirlzt
 *
 * LeetCode Mock Interview #228. Summary Ranges
 *
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        // Two pointers
        int left = 0, right = 0;
        while (right < nums.length) {
            int pre = left;
            while (right < nums.length - 1 && nums[right + 1] == nums[pre] + 1) {
                pre++;
                right++;
            }

            if (left == right) {
                res.add(String.valueOf(nums[right]));
                right++;
                left++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(nums[left]));
                sb.append("->");
                sb.append(String.valueOf(nums[right]));
                res.add(sb.toString());
                left = right + 1;
                right = left;
            }

        }

        return res;
    }
}
