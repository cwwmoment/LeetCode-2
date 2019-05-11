/**
 * Created on 11 May 2019 by happygirlzt
 *
 * LeetCode #812. Largest Triangle Area
 *
 */

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, areaCal(points[i], points[j], points[k]));
                }
            }
        }

        return res;
    }

    public double areaCal(int[] pt1, int[] pt2, int[] pt3) {
        return Math.abs(pt1[0] * (pt2[1] - pt3[1]) + pt2[0] * (pt3[1] - pt1[1]) + pt3[0] * (pt1[1] - pt2[1])) / 2.0;
    }
}
