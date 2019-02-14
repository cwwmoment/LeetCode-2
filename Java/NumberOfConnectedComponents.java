/**
 * Created on 6 Nov 2018 by happygirlzt
 *
 * Updated on 6 Dec 2018
 *
 * LeetCode #323. Number of Connected Components in an Undirected Graph
 *
 */

public class NumberOfConnectedComponents {
    // Union find
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if (root1 != root2) {
                roots[root1] = root2;
                n--;
            }
        }

        return n;
    }

    public int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }

        return id;
    }

    // dfs
    public int countComponents1(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                helper(graph, i, visited);
                count++;
            }
        }

        return count;
    }

    public void helper(List<List<Integer>> graph, int i, boolean[] visited) {
        if (visited[i]) return;

        visited[i] = true;

        for (int node : graph.get(i)) {
            helper(graph, node, visited);
        }
    }

    // Updated on 14 Feb 2019
    class DSU {
        int[] size;
        int[] parent;
        int count;
        
        public DSU(int N) {
            size = new int[N];
            parent = new int[N];
            
            for (int i = 0; i < N; i++) {
                size[i] = 1;
                parent[i] = i;
            }
            count = 0;
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
    
    public int countComponents2(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return n;
        DSU dsu = new DSU(n);
        dsu.count = n;
        
        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
        }
        
        return dsu.count;
    }
}
