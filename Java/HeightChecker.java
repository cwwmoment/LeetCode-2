/**
 * Created on 26 May 2019 by happygirlzt
 *
 * LeetCode #1051. Height Checker
 *
 */

class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] sorted = new int[n];
        System.arraycopy(heights, 0, sorted, 0, n);
        Arrays.sort(sorted);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (sorted[i] != heights[i]) {
                res++;
            }
        }

        return res;
    }
}
