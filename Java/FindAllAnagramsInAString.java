/**
 * Created on 16 Oct 2018 by happygirlzt
 *
 * LeetCode #438. Find All Anagrams in a String
 */

public class FindAllAnagramsInAString {
    // TLE
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        List<Integer> res = new ArrayList<>();

        char[] cp = p.toCharArray();
        Arrays.sort(cp);

        for (int i = 0; i < sLen - pLen + 1; i++) {
            if (Arrays.equals(Arrays.sort(s.substring(i, i + pLen).toCharArray()), cp)) {
                res.add(i);
            }
        }

        return res;
    }

    // sliding window
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
        int[] hash = new int[256];

        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) count--;

            if (count == 0) res.add(left);

            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }

        return res;
    }

    // Updated on 1 Feb 2019
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] map = new int[26];

        for (int i = 0; i < p.length(); i++) {
            map[s.charAt(i) - 'a']--;
            map[p.charAt(i) - 'a']++;
        }
        if (allZeros(map)) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            map[s.charAt(i) - 'a']--;
            map[s.charAt(i - p.length()) - 'a']++;
            if (allZeros(map)) res.add(i - p.length() + 1);
        }

        return res;
    }

    private boolean allZeros(int[] map) {
        for (int i : map) {
            if (i != 0) return false;
        }
        return true;
    }
}
