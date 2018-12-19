/**
 * Created on 19 Dec 2018 by happygirlzt
 *
 * LeetCode #345. Reverse Vowels of a String
 *
 */

class Solution {
    // static String dict = "aeiouAEIOU";

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int left = 0, right = s.length() - 1;
        char[] cs = s.toCharArray();
        while (left < right) {
            while (left < right && !set.contains(cs[left])) {
                left ++;
            }

            while (left < right && !set.contains(cs[right])) {
                right--;
            }
            char tmp = cs[left];
            cs[left] = cs[right];
            cs[right] = tmp;
            right--;
            left++;
        }

        return new String(cs);
    }

}
