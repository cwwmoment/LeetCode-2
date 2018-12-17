/**
 * Created on 17 Dec 2018 by happygirlzt
 *
 * LeetCode #342. Power of Four
 *
 */

class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        while (num % 4 == 0) num /= 4;
        return num == 1;
    }
}
