/**
 * Created on 19 Dec 2018 by happygirlzt
 *
 * LeetCode #290. Word Pattern
 *
 */

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, Integer> pMap = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (pMap.put(pattern.charAt(i), i) != sMap.put(words[i], i)) {
                return false;
            }
        }

        return true;
    }
}
