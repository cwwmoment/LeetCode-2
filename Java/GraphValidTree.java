/**
 * Created on 15 Nov 2018 by happygirlzt
 *
 * LeetCode #261. Graph Valid Tree
 *
 */

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        Arrays.fill(roots, -1);

        for (int i = 0; i < edges.length; i++) {
            int root1 = find(roots, edges[i][0]);
            int root2 = find(roots, edges[i][1]);

            if (root1 == root2) return false;

            roots[root1] = root2;
        }

        return edges.length == n - 1;
    }

    public int find(int[] roots, int i) {
        if (roots[i] == -1) return i;
        return find(roots, roots[i]);
    }

    // Updated on 1 Apr 2019
    class DSU {
        int[] root;
        int[] size;
        int count;
        public DSU(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            count = n;
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }

            return root[x];
        }

        public void union(int x, int y) {
            int rootX = root[x];
            int rootY = root[y];
            if (rootX  == rootY) return;

            if (size[rootX] <= size[rootY]) {
                root[rootX] = rootY;
                size[rootY]++;
            } else {
                root[rootY] = rootX;
                size[rootX]++;
            }
            count--;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            int rootX = dsu.find(x);
            int rootY = dsu.find(y);
            if (rootX == rootY) return false;
            dsu.union(x, y);
        }

        return dsu.count == 1;
    }
}
