/**
 * Created on 11 Dec 2018 by happygirlzt
 * 
 * LeetCode #89. Gray Code
 * 
 */ 
class Solution {
    int nums = 0;
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        helper(n, res);
        return res;
    }
    
    private void helper(int n, List<Integer> res) {
        if (n == 0) {
            res.add(nums);
        } else {
            helper(n - 1, res);
            nums ^= (1 << n - 1);
            helper(n - 1, res);
        }
    }        
}