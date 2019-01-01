/**
 * Created on 1 Jan 2019 by happygirlzt
 *
 * LeetCode #890. Find and Replace Pattern
 *
 */

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String candidate: words) {
            if (match(candidate, pattern)) {
                res.add(candidate);
            }
        }

        return res;
    }

    private boolean match(String s, String p) {
        if (s.length() != p.length()) return false;
        Map<Character, Character> map = new HashMap<>();

        // In case a letter map to different letters
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), p.charAt(i));
            }

            if (map.get(s.charAt(i)) != p.charAt(i)) return false;
        }

        // In case a letter matches to more than 1 letter
        boolean[] seen = new boolean[26];
        for (char c: map.values()) {
            if (seen[c - 'a']) {
                return false;
            }
            seen[c - 'a'] = true;
        }

        return true;
    }
}
