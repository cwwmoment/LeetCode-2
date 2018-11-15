/**
 * Created on 15 Nov 2018 by happygirlzt
 *
 * LeetCode #547. Friend Circles
 *
 */

public class FriendsCircles {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                res++;
            }
        }

        return res;
    }

    public void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }
}
