/**
 * Created on 14 Oct 2018 by happygirlzt
 *
 * LeetCode #680. Valid Palindrome II
 */

public class ValidPalindrome2 {
    // buggy code
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        char[] cs = s.toCharArray();

        boolean flag = false;

        int l = 0, r = 0;
        while (left <= right) {
            if (cs[left] != cs[right] && flag == false) {

                if (cs[left + 1] == cs[right]) {
                    l = left;
                    r = right - 1;
                    left++;
                } else if (cs[left] == cs[right - 1]) {
                    right--;
                } else {
                    return false;
                }

                flag = true;
            } else if (cs[left] != cs[right] && flag == true) {
                if (cs[l] == cs[r]) {
                    continue;
                } else {
                    return false;
                }
            }

            right--;
            left++;
        }

        return true;
    }

    // bug-free
    public boolean validPalindrome1(String s) {
        if (s == null || s.length() == 0) return true;
        int left = -1, right = s.length();
        while (++left <= --right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValid(s, left - 1, right) || isValid(s, left, right + 1);
            }
        }

        return true;
    }

    public boolean isValid(String s, int left, int right) {
        while (++left <= --right) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }

        return true;
    }
}
