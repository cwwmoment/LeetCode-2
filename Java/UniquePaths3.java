/**
 * Created on 20 Jan 2019 by happygirlzt
 *
 * LeetCode #980. Unique Paths III
 *
 */

class Solution {
    int empty = 1;
    private int sx, sy;
    private int ex, ey;
    int res = 0;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }

        dfs(grid, sx, sy);
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || grid[x][y] < 0) return;
        if (x == ex && y == ey && empty == 0) {
            res++;
            return;
        }

        empty--;
        grid[x][y] = -2;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        grid[x][y] = 0;
        empty++;
    }
}
