/**
 * Created on 16 Dec 2018 by happygirlzt
 *
 * LeetCode #276. Paint Fence
 *
 */

class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;

        int[] sameColor = new int[n];
        int[] differentColor = new int[n];
        sameColor[0] = k;
        sameColor[1] = k;
        differentColor[0] = k;
        differentColor[1] = k * (k - 1);

        for (int i = 2; i < n; i++) {
            sameColor[i] = differentColor[i - 1];
            differentColor[i] = (k - 1) * sameColor[i - 1] + (k - 1) * differentColor[i - 1];
        }

        return sameColor[n - 1] + differentColor[n - 1];
    }
}
