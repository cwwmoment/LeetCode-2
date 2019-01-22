/**
 * Created on 22 Jan 2019 by happygirlzt
 *
 * LeetCode #633. Sum of Square Numbers
 *
 */

class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) return true;
        }

        return false;
    }
}
