/**
 * Created on 16 Jan 2019 by happygirlzt
 *
 * LeetCode #845. Longest Mountain in Array
 *
 */

class Solution {
    public int longestMountain(int[] a) {
        int n = a.length, res = 0;
        int[] up = new int[n], down = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                down[i] = down[i + 1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] > a[i - 1]) {
                up[i] = up[i - 1] + 1;
            }

            if (up[i] > 0 && down[i] > 0) {
                res = Math.max(res, up[i] + down[i] + 1);
            }
        }

        return res;
    }
}
