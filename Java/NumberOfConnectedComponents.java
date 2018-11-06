/**
 * Created on 6 Nov 2018 by happygirlzt
 *
 * LeetCode #323. Number of Connected Components in an Undirected Graph
 *
 */

public class NumberOfConnectedComponents {
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
}
