/**
 * Created on 7 Mar 2019 by happygirlzt
 *
 * LeetCode #247. Strobogrammatic Number II
 *
 */

public class Solution {
    private final char[][] mapping = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public List<String> strobogrammticNumber2(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) return res;
        char[] chs = new char[n];
        helper(res, chs, 0, n - 1);
        return res;
    }

    private void helper(List<String> res, char[] chs, int lo, int hi) {
        if (lo > hi) {
            if (chs.length == 1 || chs[0] != '0') {
                res.add(String.valueOf(chs));
            }

            return;
        }

        for (char[] map : mapping) {
            if (lo == hi && map[0] != map[1]) continue;
            chs[lo] = map[0];
            chs[hi] = map[1];
            helper(res, chs, lo + 1, hi - 1);
        }
    }
}
