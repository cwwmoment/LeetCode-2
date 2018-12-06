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
}
