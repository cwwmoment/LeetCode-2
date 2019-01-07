/**
 * Created on 7 Jan 2019 by happygirlzt
 *
 * LeetCode #524. Longest Word in Dictionary through Deleting
 *
 */

class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (s1, s2) -> {
                if (s2.length() != s1.length()) {
                    return s2.length() - s1.length();
                } else {
                    return s1.compareTo(s2);
                }
            });

        for (String str : d) {
            if (isSubsequence(str, s)) {
                return str;
            }
        }

        return "";
    }

    private boolean isSubsequence(String str, String s) {
        int i = 0;
        for (int j = 0; j < s.length() && i < str.length(); j++) {
            if (str.charAt(i) == s.charAt(j)) {
                i++;
            }
        }

        return i == str.length();
    }
}
