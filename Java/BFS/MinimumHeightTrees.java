/**
 * Created on 10 Feb 2019 by happygirlzt
 *
 * LeetCode #310. Minimum Height Trees
 *
 */

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) return res;

        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.put(i, new HashSet<>());
        }

        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1) {
                res.add(i);
            }
        }

        while (n > 2) {
            n -= res.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : res) {
                for (int j : g.get(i)) {
                    g.get(j).remove(i);
                    if (g.get(j).size() == 1) newLeaves.add(j);
                }
            }
            res = newLeaves;
        }

        return res;
    }
}