/**
 * Created on 16 Oct 2018 by happygirlzt
 *
 * LeetCode #242. Valid Anagram
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);

        return Arrays.equals(cs1, cs2);
    }

    // Updated on 14 Jan 2019
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return t.length() == 0;

        char[] c1 = charCounts(s);
        char[] c2 = charCounts(t);

        return Arrays.equals(c1, c2);
    }

    private char[] charCounts(String s) {
        char[] res = new char[26];
        for (char c: s.toCharArray()) {
            res[c - 'a']++;
        }

        return res;
    }
}
