/**
 * Created on 29 Nov 2018 by happygirlzt
 *
 * LeetCode #266. Palindrome Permutation
 *
 */

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        char[] cs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odd++;
            }

            if (odd > 1) return false;
        }

        return true;
    }

    // Other's space O(1)
    public boolean canPermutePalindrome1(String s) {
        char[] cs = s.toCharArray();
        int unique = 0;
        int[] numbers = new int[128];

        for (char c : cs) {
            numbers[c]++;

            if (numbers[c] % 2 == 0) {
                unique--;
            } else {
                unique++;
            }
        }

        return unique <= 1;
    }

    // Updated on 4 Feb 2019
    public boolean canPermutePalindrome2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                count++;
            }
        }

        return count <= 1;
    }
}
