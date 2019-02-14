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

    // Updated on 14 Feb 2019
    class DSU {
        int[] size;
        int[] parent;
        int count;
        
        public DSU(int N) {
            size = new int[N];
            parent = new int[N];
            
            Arrays.fill(size, 1);
           // Arrays.fill(parent, -1);
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            
            count = N;
        }
        
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }
        
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            if (size[i] < size[j]) {
                parent[i] = j;
                size[j] += size[i];
            } else {
                parent[j] = i;
                size[i] += size[j];
            }
            
            count--;
        }
    }
    
    public int findCircleNum2(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int N = M.length;
        DSU dsu = new DSU(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1) {
                   // if (dsu.parent[i] == -1) dsu.parent[i] = i;
                    dsu.union(i, j);
                }
            }
        }
        
        return dsu.count;
    }
}
