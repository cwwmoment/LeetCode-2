/**
 *
 * Created on 8 Dec 2018 by happygirlzt
 * 
 * LeetCode #668. Kth Smallest Number in Multiplication Table
 * 
 **/
 
 class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(mid, m, n) < k) {
                left = mid + 1;   
            } else {
                right = mid;   
            }
        }
        return right;
    }
    
    private int count(int x, int m, int n) {
        int cnt = 0;
        int j = m;        
        for (int i = 1; i <= n; i++) {
            while (j > 0 && i * j > x) {
                j--;
            }
            cnt += j;
        }
        return cnt;
    }
}