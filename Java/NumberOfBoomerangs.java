/**
 * Created on 21 Dec 2018 by happygirlzt
 *
 * LeetCode #447. Number of Boomerangs
 *
 */

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (Arrays.equals(p1, p2)) continue;
                int dist = getDistance(p1, p2);
                int cnt = map.getOrDefault(dist, 0);

                if (cnt > 0) count += cnt * 2;
                map.put(dist, cnt + 1);
            }


            map.clear();
        }

        return count;
    }

    private int getDistance(int[] p0, int[] p1) {
        int d1 = p0[0] - p1[0];
        int d2 = p0[1] - p1[1];
        return d1 * d1 + d2 * d2;

    }
}
