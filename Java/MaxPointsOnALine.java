/**
 * Created on 29 Dec 2018 by happygirlzt
 *
 * LeetCode #149. Max Points on a Line
 *
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        int len = points.length;
        if (len == 0) return 0;
        if (len <= 2) return len;
        // Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int overlap = 0;
            int count = 0;

            for (int j = i + 1; j < len; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }

                int mygcd = gcd(x, y);
                x /= mygcd;
                y /= mygcd;
                String ratio = String.valueOf(x) + String.valueOf(y);
                map.put(ratio, map.getOrDefault(ratio, 0) + 1);
                // count = map.get(ratio);
                count = Math.max(count, map.get(ratio));
            }

            max = Math.max(max, count + overlap + 1);
        }

        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
