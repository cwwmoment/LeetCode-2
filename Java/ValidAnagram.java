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
}
