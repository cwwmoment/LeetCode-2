/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #541. Reverse String II
 *
 */

class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        if (len < k) {
            return new StringBuilder(s).reverse().toString();
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i <= len; i += 2 * k) {
            int start = i, end = Math.min(i + k - 1, len - 1);
            while (start < end) {
                swap(cs, start++, end--);
            }
        }

        return new String(cs);
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
