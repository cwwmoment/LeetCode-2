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

    // Updated on 7 Apr 2019
    public int maxPoints1(Point[] points) {
        int n = points.length;
        if (n < 3) return n;
        int max = 2;
        for (int i = 1; i < n; i++) {
            int count = 0;
            long x1 = points[i - 1].x;
            long y1 = points[i - 1].y;
            long x2 = points[i].x;
            long y2 = points[i].y;

            if (x1 == x2 && y1 == y2) {
                for (int j = 0; j < n; j++) {
                    if (points[j].x == x1 &&
                        points[j].y == y1) {
                        count++;
                    }
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if ((points[j].y - y2) * (x2 - x1) ==
                        (y2 - y1) * (points[j].x - x2)) {
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
