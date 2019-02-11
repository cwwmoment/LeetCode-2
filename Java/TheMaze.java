/**
 * Created on 8 Nov 2018 by happygirlzt
 *
 * LeetCode #490. The Maze
 *
 */

// Pay attention to the condition of visited
// Updated on 11 Feb 2019
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[] r = {1, -1, 0, 0};
        int[] c = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            
            for (int i = 0; i < 4; i++) {
                int rr = cur[0] + r[i];
                int cc = cur[1] + c[i];
                while (rr >= 0 && cc >= 0 && rr < maze.length && cc < maze[0].length && maze[rr][cc] == 0) {
                    rr += r[i];
                    cc += c[i];
                }
                
                if (!visited[rr - r[i]][cc - c[i]]) {
                    q.offer(new int[]{rr - r[i], cc - c[i]});
                    visited[rr - r[i]][cc - c[i]] = true;
                }
            }
        }
        
        return false;
    }
}