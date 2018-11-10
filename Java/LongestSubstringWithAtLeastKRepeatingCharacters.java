/**
 * Created on 10 Nov 2018 by happygirlzt
 *
 * LeetCode #395. Longest Substring with At Least K Repeating Characters
 *
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    // recursive divide and conquer
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    public int helper(String s, int start, int end, int k) {
        char[] cs = s.toCharArray();
        if (end - start < k) return 0;
        int[] count = new int[26];

        for (int i = start; i < end; i++) {
            count[cs[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                for (int j = start; j < end; j++) {
                    if (cs[j] == i + 'a') {
                        int left = helper(s, start, j, k);
                        int right = helper(s, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }

        return (end - start);
    }
}
