/**
 * Created on 19 Feb 2019 by happygirlzt
 * 
 * LeetCode #477. Total Hamming Distance
 */

class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
    
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int n : nums) {
               ones += (n >> i) & 1;
            }
            
            res += (nums.length - ones) * ones;
        }
        
        return res;
    }
}