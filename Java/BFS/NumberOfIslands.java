/**
 * Created on 7 Nov 2018 by happygirlzt
 *
 * LeetCode #200. Number of Islands
 *
 */

public class NumberOfIslands {
    private class Point {
        int x; int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        // corner case
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, m, n);
                    res++;
                }
            }
        }

        return res;
    }

    public void bfs(char[][] grid, int i, int j, int m, int n) {
        Queue<Point> q = new LinkedList<>();
        grid[i][j] = '0';
        q.offer(new Point(i, j));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int[] dir : dirs) {
                int row = p.x + dir[0];
                int col = p.y + dir[1];

                if (row < 0 || col < 0 || row >= m || col >= n) continue;

                if (grid[row][col] == '1') {
                    q.offer(new Point(row, col));
                    grid[row][col] = '0';
                }
            }
        }
    }
}
