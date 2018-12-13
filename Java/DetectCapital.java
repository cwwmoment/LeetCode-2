/**
 * Created on 13 Dec 2018 by happygirlzt
 *
 * LeetCode #520. Detect Capital
 *
 */

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) return true;

        // turn the string to lowercase or uppercase of change the first
        // char, if all these 3 conditions cannot be equal to the original
        // string, the return false
        if (word.equals(word.toUpperCase())) {
            return true;
        } else if (word.equals(word.toLowerCase())) {
            return true;
        } else if(word.charAt(0) == word.toUpperCase().charAt(0)) {
            return word.substring(1).equals(word.substring(1).toLowerCase());
        }

        return false;
    }
}
