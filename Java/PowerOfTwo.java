/**
 * Created on 17 Dec 2018 by happygirlzt
 *
 * LeetCode #231. Power of Two
 *
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }
}
