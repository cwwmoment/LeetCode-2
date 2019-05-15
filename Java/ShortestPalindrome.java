/**
 * Created on 15 May 2019 by happygirlzt
 *
 * LeetCode #214. Shortest Palindrome
 *
 */

class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (isPalindrome(s, 0, n - 1)) return s;
        int minLen = n - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i * 2 < n; i++) {
            int left = 0;
            int right = i * 2;

            if (isPalindrome(s, left, right)) {
                minLen = Math.min(n - right - 1, minLen);
            } else if (isPalindrome(s, left, --right)) {
                minLen = Math.min(n - right - 1, minLen);
            }
        }

        int index = n - 1;
        for (int i = minLen; i > 0; i--) {
            sb.append(s.charAt(index--));
        }

        sb.append(s);
        return sb.toString();
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }

        return true;
    }
}
