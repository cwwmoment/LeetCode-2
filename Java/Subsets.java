/**
 * Created on 23 Jan 2019 by happygirlzt
 *
 * LeetCode #78. Subsets
 *
 */

class Solution {
    public List<List<Integer>> subsets(int[] a) {
        Set<List<Integer>> res = new HashSet<>();
        if (a == null || a.length == 0) return new ArrayList();
        helper(res, new ArrayList<Integer>(), a, 0);
        res.add(new ArrayList());
        List<List<Integer>> r = new ArrayList();
        r.addAll(res);
        return r;
    }

    private void helper(Set<List<Integer>> res, List<Integer> cur, int[] a, int start) {
        if (start == a.length) {
            return;
        }

        for (int i = start; i < a.length; i++) {
            cur.add(a[i]);
            res.add(new ArrayList(cur));
            helper(res, cur, a, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
