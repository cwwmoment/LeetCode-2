/**
 * Created on 8 Nov 2018 by happygirlzt
 *
 * LeetCode #490. The Maze
 *
 */

// Pay attention to the condition of visited
// 入了队列才算visited。。这样就可以避免重复，也不会漏算。
public class TheMaze {
    // BFS
    public final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        if (maze == null || maze.length == 0) return true;
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        return bfs(maze, start, dest, m, n);
    }

    public boolean bfs(int[][] maze, int[] start, int[] dest, int m, int n, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            visited[cur[0]][cur[1]] = true;
            if (Arrays.equals(cur, dest)) return true;

            for (int[] dir : dirs) {
                int[] nextPost = new int[]{cur[0] + dir[0], cur[1] + dir[1]};
                boolean flag = false;

                while (valid(maze, nextPost, m, n)) {
                    flag = true;
                    nextPost[0] += dir[0];
                    nextPost[1] += dir[1];
                    // visited[nextPost[0][nextPost[1]]] = true;
                    //maze[nextPost[0]][nextPost[1]] = 1;
                }

                if (!flag) continue;
                nextPost[0] -= dir[0];
                nextPost[1] -= dir[1];

                if (Arrays.equals(nextPost, dest)) return true;

                if (!visited[nextPost[0]][nextPost[1]]) q.offer(nextPost);
            }
        }

        return false;
    }

    public boolean valid(int[][] maze, int[] nextPost, int m, int n) {
        if (nextPost[0] < 0 || nextPost[0] >= m ||
            nextPost[1] < 0 || nextPost[1] >= n ||
            maze[nextPost[0]][nextPost[1]] == 1) return false;

        return true;
    }

    // DFS
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        return dfs(maze, start[0], start[1], dest, maze.length, maze[0].length);
    }

    public boolean dfs(int[][] maze, int i, int j, int[] des, int m, int n) {
        // base case
        if (i == des[0] && j == des[1]) return true;

        maze[i][j] = 2;

        // up
        int row = i, col = j;
        while (row > 0 && maze[row - 1][col] != 1) row--;
        if (row < i && maze[row][col] == 0 && dfs(maze, row, col, des)) return true;

        // down
        row = i;
        while (row < m - 1 && maze[row + 1][col] != 1) row++;
        if (row > i && maze[row][col] == 0 && dfs(maze, row, col, des)) return true;

        // left
       row = i;
        while (col > 0 && maze[row][col - 1] != 1) col--;
        if (col < j && maze[row][col] == 0 && dfs(maze, row, col, des)) return true;

        // right
        col = j;
        while (col < n - 1 && maze[row][col + 1] != 1) col++;
        if (col > j && maze[row][col] == 0 && dfs(maze, row, col, des)) return true;

        return false;
    }
}
