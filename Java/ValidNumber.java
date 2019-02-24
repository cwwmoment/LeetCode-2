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
                // '-' can occur many times
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
                signSeen = true;
            } else if (c == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else return false;
        }
        
        return numSeen;
    }

    // Updated on 24 Feb 2019
    // Do not need signSeen
    // e 是科学计数法的符号，后面必须是整数
    public boolean isNumber1(String s) {
        s = s.trim();
        boolean eSeen = false;
        boolean numSeen = false;
        boolean dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numSeen = false;
            } else if (c == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }
        
        return numSeen;
    }
}