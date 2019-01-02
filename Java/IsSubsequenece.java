/**
 * Created on 2 Jan 2019 by happygirlzt
 *
 * LeetCode #392. Is Subsequence
 *
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int i = 0;
        for (int j = 0; j < ts.length; j++) {
            if (i == cs.length) return true;
            if (cs[i] == ts[j]) {
                i++;
            }
        }

        return i == cs.length;
    }
}
