/**
 * Created on 10 Mar 2019 by happygirlzt
 *
 * LeetCode #678. Valid Parenthesis String
 *
 */

class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int starCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else if (starCount > 0) {
                    starCount--;
                } else return false;
            } else {
                starCount++;
            }
        }

        if (open == 0) return true;
        // If open parenthesis are more than close, the more parentheis
        // may be turned from the star, so we need to check again from
        // the right
        int close = 0;
        starCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                close++;
            } else if (c == '(') {
                if (close > 0) {
                    close--;
                } else if (starCount > 0) {
                    starCount--;
                } else return false;
            } else {
                starCount++;
            }
        }

        return true;
    }
}
