/**
 * Created on 15 Nov 2018 by happygirlzt
 *
 * Updated on 6 Dec 2018
 *
 * LeetCode #547. Friend Circles
 *
 */

public class FriendsCircles {
    public int findCircleNum1(int[][] m) {
        if (m == null || m.length == 0) return 0;

        int n = m.length;
        boolean[] visited = new boolean[n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (m[i][i] == 1 && !visited[i]) {
                res++;
                helper(m, i, visited);
            }
        }

        return res;
    }

    public void helper(int[][] m, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && !visited[j]) {
                helper(m, j, visited);
            }
        }
    }

    // Union find
    public int findCircleNum(int[][] m) {
        if (m == null || m.length == 0) return 0;
        int n = m.length;
        int[] roots = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        int res = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (m[i][j] == 1) {
                    int r1 = find(roots, i);
                    int r2 = find(roots, j);

                    if (r1 != r2) {
                        roots[find(roots, r1)] = roots[find(roots, r2)];
                        res--;
                    }
                }
            }
        }

        return res;
    }

    public int find(int[] roots, int i) {
        if (roots[i] == i) return i;

        roots[i] = find(roots, roots[i]);

        return roots[i];
    }
}
