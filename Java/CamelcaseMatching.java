/**
 * Created on 8 May 2019 by happygirlzt
 *
 * LeetCode #1023. Camelcase Matching
 *
 */

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        for (String q : queries) {
            boolean isMatch = helper(q, pattern);
            res.add(isMatch);
        }

        return res;
    }

    private boolean helper(String q, String p) {
        int i = 0, j = 0;
        while (i < q.length()) {
            if (j < p.length() && q.charAt(i) == p.charAt(j)) {
                j++;
            } else if (q.charAt(i) >= 'A' &&
                       q.charAt(i) <= 'Z') {
                return false;
            }
            i++;
        }

        return j == p.length();
    }
}
