/**
 * LeetCode 200. Number of Islands
 * Created on 24/08/2018
 * @author happygirlzt
 * 6 Nov 2018 second
 */
public class NumberOfIslands {
    /**
     * DFS: 数有多少个岛屿，也就是有多少块连着的1
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) return res;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != '1') {
                    continue;
                } else {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length ||
            j >= grid[0].length || grid[i][j] != '1') return;
        // Visited is assigned to '2'
        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
    }

    // 6 Nov 2018
    // dfs
    // bfs
    public static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private class Point {
        int x; int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int res = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // q.offer(new Point(i, j));
                    bfs(grid, i, j, m, n);
                    res++;
                }
            }
        }

        return res;
    }

    // fill the 1's neighbour into 0
    public void bfs(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '0';

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int[] dir : dirs) {
                int row = p.x + dir[0];
                int col = p.y + dir[1];

                // corner case
                if (row < 0 || col < 0 || row >= m || col >= n) continue;

                if (grid[row][col] == '1') {
                    q.offer(new Point(row, col));
                    grid[row][col] = '0';
                }
            }
        }
    }
}
