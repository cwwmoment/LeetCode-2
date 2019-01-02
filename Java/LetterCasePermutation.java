/**
 * Created on 1 Jan 2019 by happygirlzt
 *
 * LeetCode #784. Letter Case Permutation
 *
 */

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        char[] cs = S.toLowerCase().toCharArray();
        helper(res, cs, 0);
        return res;
    }

    private void helper(List<String> res, char[] cs, int pos) {
        if (pos == cs.length) {
            res.add(new String(cs));
            return;
        } else {
            helper(res, cs, pos + 1);
            if (Character.isLetter(cs[pos])) {
                cs[pos] = Character.toUpperCase(cs[pos]);
                helper(res, cs, pos + 1);
                cs[pos] = Character.toLowerCase(cs[pos]);
            }
        }
    }
}
