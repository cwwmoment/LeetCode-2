/**
 * Created on 22 Dec 2018 by happygirlzt
 *
 * LeetCode #187. Repeated DNA Sequences
 *
 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) return new ArrayList();
        Set<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            if (set.contains(s.substring(i, i + 10))) {
                seen.add(s.substring(i, i + 10));
            }
            set.add(s.substring(i, i + 10));
        }
        return new ArrayList(seen);
    }
}
