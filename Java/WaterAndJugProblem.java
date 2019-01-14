/**
 * Created on 14 Jan 2019 by happygirlzt
 *
 * LeetCode #365. Water and Jug Problem
 *
 */

// This is a pure math problem...
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;

        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }
}
