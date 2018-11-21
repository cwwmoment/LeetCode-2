/**
 * Created on 21 Nov 2018 by happygirlzt
 *
 * LeetCode #573 Squirrel Simulation
 *
 */

class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int dist = 0, d = Integer.MIN_VALUE;
        for (int[] nut: nuts) {
            dist += (distance(nut, tree) * 2);
            d = Math.max(d, distance(nut, tree) - distance(nut, squirrel));
        }
        return dist - d;
    }
    public int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);

    }
}
