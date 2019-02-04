/**
 * Created on 4 Feb 2019 by happygirlzt
 *
 * LeetCode #9. Palindrome Number
 *
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rev = 0;
        int n = x;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }

        // System.out.println(rev);
        return rev == x;
    }
}
