/**
 * Created on 17 Dec 2018 by happygirlzt
 *
 * LeetCode #326. Power of Three
 *
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }
}
