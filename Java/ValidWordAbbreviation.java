/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #408. Valid Word Abbreviation
 *
 */

class Solution {
    // My solution
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr == null || abbr.length() == 0) return false;
        if (abbr.length() > word.length()) return false;
        if (word.equals(abbr)) return true;

        int len = abbr.length();
        char[] ws = word.toCharArray();
        char[] as = abbr.toCharArray();

        int j = 0, con = 0, i = 0;
        for (i = 0; i < len; i++) {
            if (Character.isLetter(as[i])) {
                if (j >= ws.length || as[i] != ws[j]) return false;
                j++;
                con = 0;
            } else if (Character.isDigit(as[i])) {
                if (con == 0)
                    j = j + as[i] - '0';
                else
                    j = con * 10 + as[i] - '0' + j - con;
                con++;
            } else {
                return false;
            }
        }

        // Remember to check if both pointers are in the end
        return i == as.length && j == ws.length;
    }

    // Other's
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        int num = 0;
        while (i < word.length() && j < abbr.length()) {
            if (abbr.charAt(j) == '0')
                return false;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                num = num * 10 + (int)(abbr.charAt(j++) - '0');
            }
            if (num != 0) {
                i += num;
                num = 0;
            } else {
                if (j >= abbr.length())
                    return false;
                if (word.charAt(i) != abbr.charAt(j))
                    return false;
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
