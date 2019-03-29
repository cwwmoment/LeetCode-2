/**
 * Created on 6 Dec 2018 by happygirlzt
 *
 * LeetCode #684. Redundant Connection
 *
 */

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int[] edge: edges){
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) return edge;
            else parent[find(parent, f)] = find(parent, t);
        }

        return new int[2];
    }

    private int find(int[] parent, int f) {
        if (f != parent[f]) {
            parent[f] = find(parent, parent[f]);
        }
        return parent[f];
    }

    // Updated on 29 Mar 2019
    class DSU {
        int[] size;
        int n;
        int[] root;
        int count;

        public DSU(int n) {
            this.n = n;
            count = n;
            size = new int[n];
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;

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

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return new int[0];
        int n = edges.length;
        DSU dsu = new DSU(n + 1);
        for (int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
            if (dsu.find(x) == dsu.find(y)) return edge;
            dsu.union(x, y);
        }

        return new int[0];
    }
}
