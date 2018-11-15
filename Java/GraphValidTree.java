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
}
