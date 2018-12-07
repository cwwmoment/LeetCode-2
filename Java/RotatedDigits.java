/**
 * Created on 7 Dec 2018 by happygirlzt
 * 
 * LeetCode #788. Rotated Digits
 * 
 * */

class Solution {
    public int rotatedDigits(int n) {
        int[] dp = new int[n + 1];
        int count = 0;
        
        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                if (i == 1 || i == 0 || i == 8) {
                    dp[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                // 11
                if (a == 1 && b == 1) {
                    dp[i] = 1;
                } else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                }
                
            }
        }
        
        return count;
    }
}