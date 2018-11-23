/**
 * LeetCode #695. Max Area of Island
 *
 * Created by happygirlzt on 5 Sep 2018 at 10:44:24 PM
 *
 */
public class MaxAreaOfIsland {
    // DFS
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public int areaOfIsland(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0) {
            grid[i][j] = 0;
            return 1 + areaOfIsland(grid, i + 1, j) + areaOfIsland(grid, i - 1, j) +
                areaOfIsland(grid, i, j + 1) + areaOfIsland(grid, i, j - 1);
        }

        return 0;
    }


    // Update on 23 Nov 2018
    private class Point {
        int x; int y;
        Point(int x, int y) {
            x = x;
            y = y;
        }
    }

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] res = new int[1];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    bfs(grid, i, j, visited, res);
                }
            }
        }

        return res[0];
    }

    public void bfs(int[][] grid, int i, int j, boolean[][] visited, int[] res) {
        int tmp = 1;
        // Queue<Point> q = new LinkedList<>();
        // q.offer(new Point(i, j));
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            // Point cur = q.poll();
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            System.out.println("row = " + row + " col = " + col);

            for (int[] dir : dirs) {
                if ((row + dir[0] < 0) || (row + dir[0] >= grid.length) ||
                    (col + dir[1] < 0) || (col + dir[1] >= grid[0].length) ||
                    visited[row + dir[0]][col + dir[1]]) continue;

                if (grid[row + dir[0]][col + dir[1]] == 1) {
                    tmp++;
                    System.out.println(row + dir[0] + " " + col + dir[1]);

                    q.offer(new int[]{row + dir[0], col + dir[1]});
                    visited[row + dir[0]][col + dir[1]] = true;
                }
            }
        }

        res[0] = Math.max(res[0], tmp);
    }
}
