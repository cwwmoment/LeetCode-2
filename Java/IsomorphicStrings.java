/**
 * Created on 16 Nov 2018 by happygirlzt
 *
 * LeetCode #205. Isomorphic Strings
 *
 */

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s == null || s.length() == 0) return true;

        int[] m1 = new int[256];
        int[] m2 = new int[256];
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (m1[cs[i]] != m2[ts[i]]) return false;
            m1[cs[i]] = i + 1;
            m2[ts[i]] = i + 1;
        }

        return true;
    }
}
