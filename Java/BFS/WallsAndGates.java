/**
 * Created on 7 Nov 2018 by happygirlzt
 *
 * LeetCode #286. Walls and Gates
 *
 */

public class WallsAndGates {
    private class Point {
        int x; int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j, m, n);
                }
            }
        }
    }

    public void bfs(int[][] rooms, int i, int j, int m, int n) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int[] dir : dirs) {
                int row = cur.x + dir[0];
                int col = cur.y + dir[1];

                if (row >= m || col >= n || row < 0 || col < 0 || rooms[row][col] == -1) continue;
                if (rooms[row][col] == 2147483647 || (rooms[row][col] > rooms[cur.x][cur.y] + 1)) {
                    rooms[row][col] = rooms[cur.x][cur.y] + 1;
                    q.offer(new Point(row, col));
                }
            }
        }
    }
}
