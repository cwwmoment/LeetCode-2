/**
 * Created on 15 Feb 2019 by happygirlzt
 * 
 * LeetCode #673. Number of Longest Increasing Subsequence
 * 
 */

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] lengths = new int[len];
        int[] counts = new int[len];
        Arrays.fill(counts, 1);
        
        int longest = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[i] <= lengths[j]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            
            longest = Math.max(longest, lengths[i]);
        }
        
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (lengths[i] == longest) {
                res += counts[i];
            }
        }
        
        return res;
    }
}