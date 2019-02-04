/**
 * Created on 14 Oct 2018 by happygirlzt
 *
 * LeetCode #125. Valid Palindrome
 */

import java.util.Stack;

public class ValidPalindrome {
    // 我的简单的写法
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        int len = s.length();
        char[] cs = s.toCharArray();
        char[] css = new char[len];
        int k = 0;
        for(int i = 0; i < len; i++) {
            if ((cs[i] >= 'a' && cs[i] <= 'z') || (cs[i] >= '0' && cs[i] <= '9')) {
                css[k++] = cs[i];
            }
        }

        int j = 0;
        k--;
        while (j <= k) {
            if (css[j] != css[k]) {
                return false;
            }
            j++;
            k--;
        }

        return true;
    }

    // 别人的相对来说比较优雅的写法
    public boolean isPalindrome1(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    // Updated on 4 Feb 2019
    public boolean isPalindrome3(String s) {
        if (s == null || s.length() == 0) return true;
        int lo = 0, hi = s.length() - 1;
        while (lo <= hi) {
            while (lo <= hi && !Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
            }

            while (lo <= hi && !Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
            }

            if (lo > hi) break;
            char L = s.charAt(lo), R = s.charAt(hi);
            // if (Character.isLetter(L) && Character.isLetter(R)) {
                if (Character.toUpperCase(L) != Character.toUpperCase(R)) {
                    return false;
                }
                // } else if (L != R) return false;

            lo++; hi--;
        }

        return true;
    }
}
