/**
 * Created on 7 Dec 2018 by happygirlzt
 *
 * LeetCode #685. Redundant Connection II
 *
 * */
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] roots = new int[edges.length + 1];

        // check if there is a node has two fathers
        for (int[] e : edges) {
            int father = e[0];
            int child = e[1];
            if (roots[child] != 0) {
                can1 = new int[]{roots[child], child};
                can2 = new int[]{father, child};
                e[1] = 0;
            } else {
                roots[child] = father;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            roots[i] = i;
        }

        for (int[] e : edges) {
            if (e[1] == 0) {
                continue;
            }

            int father = e[0];
            int child = e[1];

            if (find(roots, father) == child) {
                if (can1[0] == -1) {
                    return e;
                }

                return can1;
            }

            roots[child] = father;
        }

        return can2;
    }

    public int find(int[] roots, int i) {
        if (roots[i] != i) {
            roots[i] = find(roots, roots[i]);
        }

        return roots[i];
    }
}
