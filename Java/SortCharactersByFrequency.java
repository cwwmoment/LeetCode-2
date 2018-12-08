/**
 *
 * Created on 8 Dec 2018 by happygirlzt
 * 
 * LeetCode #451. Sort Characters By Frequency
 * 
 **/
 
 class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        
        char[] charFreq = new char[128];
        char[] cs = s.toCharArray();
        
        for (char c : cs) {
            charFreq[c]++;
        }
        
        int len = s.length();
        char[] res = new char[len];
        int pos = 0;
        while (pos < len) {
            char max = 0;            
            for (int i = 0; i < 128; i++) {
                if (charFreq[i] > charFreq[max]) {
                   max = (char) i;
                }
            }
                        
            while (charFreq[max] != 0) {
                res[pos++] = max;
                charFreq[max]--;
            }
        }
        
        return String.valueOf(res);
    }
}