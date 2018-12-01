/**
 * Created on 1 Dec 2018 by happygirlzt
 *
 * LeetCode #505. The Maze II
 *
 */

public class TheMaze2 {
    public final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return 0;

        int m = maze.length, n = maze[0].length;
        int[][] len = new int[m][n];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < m * n; i++) {
            len[i / n][i % n] = Integer.MAX_VALUE;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (len[cur[0]][cur[1]] <= cur[2]) continue;

            len[cur[0]][cur[1]] = cur[2];
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                res = Math.min(cur[2], res);
            }

            for (int[] dir : dirs) {
                int x = cur[0], y = cur[1];
                int dis = cur[2];

                while (x >= 0 && x < m &&
                       y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    dis++;
                }

                dis--;
                x -= dir[0];
                y -= dir[1];

                q.offer(new int[]{x, y, dis});
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
