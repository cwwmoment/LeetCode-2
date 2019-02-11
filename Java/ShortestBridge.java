/**
 * Created on 23 Nov 2018 by happygirlzt
 *
 * LeetCode #934. Shortest Bridge
 *
 */

public class ShortestBridge {

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] a) {
        if (a == null || a.length == 0) return 0;

        boolean[][] visited = new boolean[a.length][a[0].length];
        Queue<int[]> q = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (count != 0) break;
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    dfs(a, visited, q, i, j);
                    count = 1;
                    break;
                }
            }
        }

        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                for (int[] dir : dirs) {
                    if (row + dir[0] < 0 ||
                        row + dir[0] >= a.length ||
                        col + dir[1] < 0 ||
                        col + dir[1] >= a[0].length ||
                        visited[row + dir[0]][col + dir[1]]) continue;

                    if (a[row + dir[0]][col + dir[1]] == 1) {
                        return step;
                    }

                    q.offer(new int[]{row + dir[0], col + dir[1]});
                    visited[row + dir[0]][col + dir[1]] = true;
                }
            }
            step++;
        }

        return -1;
    }

    private void dfs(int[][] a,  boolean[][] visited, Queue<int[]> q, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || visited[i][j] || a[i][j] == 0) {
            return;
        }

        visited[i][j] = true;

        q.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(A, visited, q, i + dir[0], j + dir[1], dirs);
        }
    }
}
