/**
 * Created on 28 Feb 2019 by happygirlzt
 *
 * LeetCode #131. Palindrome Partitioning
 *
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> cur, String s, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (isValid(s, pos, i)) {
                cur.add(s.substring(pos, i + 1));
                helper(res, cur, s, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isValid(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }

        return true;
    }
}
