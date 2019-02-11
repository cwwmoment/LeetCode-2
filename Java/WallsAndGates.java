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

    // Updated on 9 Feb 2019
    private int[] r = {1, -1, 0, 0};
    private int[] c = {0, 0, 1, -1};
    
    private static final int INF = Integer.MAX_VALUE;
    private static final int GATE = 0;
    public void wallsAndGates1(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == GATE) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int rr = cur[0] + r[j];
                    int cc = cur[1] + c[j];
                    if (rr < 0 || rr > rooms.length - 1 || cc < 0 || cc > rooms[0].length - 1) continue;
                    if (rooms[rr][cc] != INF) continue;
                    rooms[rr][cc] = depth;
                    q.offer(new int[]{rr, cc});
                }                
            }
            depth++;
        }
    }
}
