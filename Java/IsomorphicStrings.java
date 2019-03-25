/**
 * Created on 16 Nov 2018 by happygirlzt
 *
 * LeetCode #205. Isomorphic Strings
 *
 */

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        if (s.length() != t.length()) return false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;  // Attach a new value
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
