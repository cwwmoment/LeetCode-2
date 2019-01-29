/**
 * Created on 29 Jan 2019 by happygirlzt
 *
 * LeetCode #296. Best Meeting Point
 *
 */

/*
This problem asks us to find the median point in 2D grid and then calculate all the points to that median point.

We can simply this problem to 1D situation.

2 tricks:
0. get the coordinate from small to larget, so do not need to sort
1. use two pointers to get the distance from all the points to the median point.
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

        return getDis(rows) + getDis(cols);
    }

    // 0, 0, 2
    private int getDis(List<Integer> rows) {
        int i = 0, j = rows.size() - 1;
        int dis = 0;
        while (i < j) {
            dis += rows.get(j) - rows.get(i);
            j--; i++;
        }

        return dis;
    }
}
