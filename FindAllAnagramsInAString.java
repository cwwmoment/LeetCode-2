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
}
