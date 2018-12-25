/**
 * Created on 25 Dec 2018 by happygirlzt
 *
 * LeetCode #161. One Edit Distance
 *
 */

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        int len1 = s.length(), len2 = t.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (len1 == len2) {
            int i = 0;
            boolean flag = false;
            while (i < len1) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (flag) return false;
                    flag = true;
                }
                i++;
            }
            return true;
        } else {
            int i = 0, j = 0;
            boolean flag = false;
            while (i < len1 && j < len2) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (flag) return false;
                    if (len1 > len2) {
                        i++;
                    } else {
                        j++;
                    }
                    flag = true;
                } else {
                    i++;
                    j++;
                }
            }
        }

        return true;
    }

    // elegant solution
    public boolean isOneEditDistance1(String s, String t) {
        if (s.equals(t)) return false;
        int len1 = s.length(), len2 = t.length();
        if (len2 < len1) {
            return isOneEditDistance(t, s);
        }

        boolean sameLen = (len1 == len2);
        for (int i = 0; i < len1; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (!sameLen)
                    return s.substring(i).equals(t.substring(i + 1));
                else
                    return s.substring(i + 1).equals(t.substring(i + 1));
            }
        }

        return (len1 + 1 == len2) || (len1 == len2);

    }
}
