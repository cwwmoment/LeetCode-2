/**
 * Created on 5 Dec 2018 by happygirlzt
 *
 * LeetCode #564. Find the Closest Palindrome
 *
 */

class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n), res = 0, len = n.length(), minDiff = Integer.MAX_VALUE;

        HashSet<Long> set = new HashSet<>();
        set.add((new Double(Math.pow(10, len) + 1)).longValue());
        set.add((new Double(Math.pow(10, len - 1) - 1)).longValue());

        long leftNum = Long.parseLong(n.substring(0, (int) (len + 1) >> 1));

        for (int i = -1; i <= 1; i++) {
            String left = String.valueOf(leftNum + i);
            String str;

            if (len % 2 == 0) {
                StringBuilder sb = new StringBuilder(left);
                str = left + sb.reverse().toString();
            } else {
                StringBuilder sb = new StringBuilder(left.substring(0, left.length() - 1));
                str = left + sb.reverse().toString();
            }

            set.add(Long.parseLong(str));
        }

        set.remove(num);
        for (Long a : set) {
            Long diff = Math.abs(a - num);
            if (diff < minDiff) {
                minDiff = diff;
                res = a;
            } else if (diff == minDiff) {
                res = Math.min(res, a);
            }
        }

        return String.valueOf(res);
    }
}
