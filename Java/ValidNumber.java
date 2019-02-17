/**
 * Created on 17 Feb 2019 by happygirlzt
 * 
 * LeetCode #65. Valid Number
 */

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean eSeen = false;
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean signSeen = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numSeen = false;
            } else if (c == '-' || c == '+') {
                // " 005047e+6" is true
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
                signSeen = true;
            } else if (c == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else return false;
        }
        
        return numSeen;
    }
}