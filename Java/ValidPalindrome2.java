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

    // Updated on 4 Feb 2019
    public boolean validPalindrome(String s) {
       /* for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i + 1, j) ||
                       isPalindromeRange(s, i, j - 1));
            }
        }
        */
        int lo = 0, hi = s.length() - 1;
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return isPalindromeRange(s, lo, hi - 1) ||
                    isPalindromeRange(s, lo + 1, hi);
            }
            lo++; hi--;
        }

        return true;
    }

    private boolean isPalindromeRange(String s, int i, int j) {
       /* for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) {
                return false;
            }
        }
        */
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
