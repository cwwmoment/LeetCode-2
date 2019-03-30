/**
 * Created on 30 Mar 2019 by happygirlzt
 *
 * LeetCode #939. Minimum Area Rectangle
 *
 */

class Solution {
    public int minAreaRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] point: points) {
            set.add(point[0] + "#" + point[1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] ||
                    points[i][1] == points[j][1]) continue;

                String s1 = points[j][0] + "#" + points[i][1];
                String s2 = points[i][0] + "#" + points[j][1];

                if (set.contains(s1) && set.contains(s2)) {
                    int area = Math.abs(points[j][0] - points[i][0]) * Math.abs(points[i][1] - points[j][1]);
                    min = Math.min(min, area);
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
