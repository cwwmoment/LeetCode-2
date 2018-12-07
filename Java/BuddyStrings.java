/**
 * Created on 7 Dec 2018 by happygirlzt
 * 
 * LeetCode #859. Buddy Strings
 * 
 * */

class Solution {
    // Two pointers
    public boolean buddyStrings(String a, String b) {
        if (a == null || b == null) return a.equals(b);
        if (a.length() != b.length()) return false;
        
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        
        int len = a.length();
        
        if (len == 1) return false;
        if (a.equals(b)) {
            HashSet<Character> set = new HashSet<>();
            for (char c: ac) {
                if (set.contains(c)) return true;
                set.add(c);
            }
            
            return false;
        }          
        
        int left = -1, right = -1;
        for (int i = 0; i < len; i++) {
            if (ac[i] == bc[i]) continue;
            if (left == -1) {
                left = i;
            } else if (right == -1) {
                right = i;
            } else {
                return false;
            }
        }
        
        if (left != -1 && right != -1) {
            return ac[left] == bc[right] && ac[right] == bc[left];
        }
        
        return false;
    }
}