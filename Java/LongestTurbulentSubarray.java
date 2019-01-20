/**
 * Created on 20 Jan 2019 by happygirlzt
 *
 * LeetCode #978. Longest Turbulent Subarray
 *
 */

class Solution {
    public int maxTurbulenceSize(int[] a) {
        int n = a.length;
        int res = 1;
        int j = 0;

        for (int i = 1; i < n; i++) {
            int c = Integer.compare(a[i - 1], a[i]);
            if (i == n - 1 || c * Integer.compare(a[i], a[i + 1]) != -1) {
                res = Math.max(res, i - j + 1);
                j = i;
            }
        }

        return res;
    }
}
