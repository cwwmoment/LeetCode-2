/**
 * Created on 12 Jan 2019 by happygirlzt
 *
 * LeetCode #317. Shortest Distance from All Buildings
 *
 */

class Solution {
    // Updated on 7 Apr 2019
    // O(m^2 n^2)
    private int[] rowDir = {1, -1, 0, 0};
    private int[] colDir = {0, 0, 1, -1};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int[][] canReach = new int[rows][cols];
        int[][] dist = new int[rows][cols];

        int totalBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    bfs(grid, i, j, dist, canReach);
                }
            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReach[i][j] == totalBuildings &&
                    dist[i][j] < minDis) {
                    minDis = dist[i][j];
                }
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private void bfs(int[][] grid, int row, int col, int[][] dist, int[][] canReach) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int d = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int k = 0; k < 4; k++) {
                    int rr = rowDir[k] + r;
                    int cc = colDir[k] + c;
                    if (isValid(grid, rr, cc, visited)) {
                        dist[rr][cc] += d;
                        canReach[rr][cc]++;
                        q.offer(new int[]{rr, cc});
                        visited[rr][cc] = true;
                    }
                }
            }
        }
    }

    private boolean isValid(int[][] grid, int rr, int cc, boolean[][] visited) {
        if (rr > grid.length - 1 ||
            rr < 0 || cc < 0 || cc > grid[0].length - 1) return false;
        if (visited[rr][cc]) return false;
        if(grid[rr][cc] != 0) return false;

        return true;
    }

    // Optimized Verison
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int[][] canReach = new int[rows][cols];
        int[][] dist = new int[rows][cols];

        int totalBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    if (!bfs(grid, i, j, dist, canReach)) return -1;
                }
            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReach[i][j] == totalBuildings &&
                    dist[i][j] < minDis) {
                    minDis = dist[i][j];
                }
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private boolean bfs(int[][] grid, int row, int col, int[][] dist, int[][] canReach) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int d = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int k = 0; k < 4; k++) {
                    int rr = rowDir[k] + r;
                    int cc = colDir[k] + c;
                    if (!isValid(grid, rr, cc, visited)) continue;
                    if (grid[rr][cc] == 0) {
                        dist[rr][cc] += d;
                        canReach[rr][cc]++;
                        q.offer(new int[]{rr, cc});
                    }
                    visited[rr][cc] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int[][] grid, int rr, int cc, boolean[][] visited) {
        if (rr > grid.length - 1 ||
            rr < 0 || cc < 0 || cc > grid[0].length - 1) return false;
        if (visited[rr][cc]) return false;
        if(grid[rr][cc] == 2) return false;

        return true;
    }
}
