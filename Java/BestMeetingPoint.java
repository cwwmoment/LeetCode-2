/**
 * Created on 29 Jan 2019 by happygirlzt
 *
 * LeetCode #296. Best Meeting Point
 *
 */

class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }

        return getDist(rows) + getDist(cols);
    }

    private int getDist(List<Integer> list) {
        int lo = 0, hi = list.size() - 1;
        int d = 0;
        while (lo < hi) {
            d += list.get(hi) - list.get(lo);
            hi--;
            lo++;
        }

        return d;
    }
}
