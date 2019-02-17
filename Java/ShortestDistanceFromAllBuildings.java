/**
 * Created on 12 Jan 2019 by happygirlzt
 *
 * LeetCode #317. Shortest Distance from All Buildings
 *
 */

class Solution {
    private int numOfHouses = 0;
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) numOfHouses++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, bfs(grid, i, j));
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int bfs(int[][] grid, int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});

        int dis = 0, houses = 0, level = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int h = 0; h < size; h++) {
                int[] cur = q.poll();

                if (grid[cur[0]][cur[1]] == 1) {
                    dis += level;
                    houses++;
                    continue;
                }

                for (int[] dir : dirs) {
                    int row = dir[0] + cur[0];
                    int col = dir[1] + cur[1];
                    if (row < 0 || row > grid.length - 1 ||
                        col < 0 || col > grid[0].length - 1 ||
                        grid[row][col] == 2 || visited[row][col]) continue;

                    visited[row][col] = true;
                    q.offer(new int[]{row, col});
                }
            }

            level++;
        }

        return houses == numOfHouses ? dis : Integer.MAX_VALUE;
    }

    // Updated on 17 Feb 2019
    // O(m^2 n^2)
    private final int[] dr = {1, -1, 0, 0};
    private final int[] dc = {0, 0, 1, -1};
    
    public int shortestDistance1(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] reach = new int[m][n];
        int totalBuildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    bfs(grid, i, j, dist, reach);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j] == totalBuildings &&
                    dist[i][j] < min) {
                    min = dist[i][j];
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void bfs(int[][] grid, int row, int col, int[][] dist, int[][] reach) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int rr = cur[0] + dr[j];
                    int cc = cur[1] + dc[j];
                    if (rr < 0 || rr > m - 1 || cc < 0
                       || cc > n - 1) continue;
                    if (visited[rr][cc]) continue;
                    if (grid[rr][cc] != 0) continue;
                    dist[rr][cc] += level;
                    reach[rr][cc]++;
                    visited[rr][cc] = true;
                    q.offer(new int[]{rr, cc});
                }
            }
        }
    }
}
