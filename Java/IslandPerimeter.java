/**
 * Created on 23 Nov 2018 by happygirlzt
 *
 * LeetCode #463. Island Perimeter
 *
 */

public class IslandPerimeter {
    // My solution
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int[] res = new int[1];
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    visited[i][j] = true;
                    bfs(grid, i, j, visited, res);
                }
            }
        }

        return res[0];
    }

    public void bfs(int[][] grid, int i, int j, boolean[][] visited, int[] res) {
        for (int[] dir : dirs) {
            // the top or bottom or leftmost or rightmost
            if ((i + dir[0] == -1) || (i + dir[0] == grid.length)
               || (j + dir[1] == -1) || (j + dir[1] == grid[0].length)) {
                res[0]++;
                continue;
            }

            if (grid[i + dir[0]][j + dir[1]] == 0) {
                // visited[i + dir[0]][j + dir[1]] = true;
                res[0]++;
            } else {
                continue;
            }
        }
    }

    // Other's smart solution
    public int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
