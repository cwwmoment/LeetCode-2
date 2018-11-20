/**
 * Created on 20 Nov 2018 by happygirlzt
 *
 * LeetCode #831. Masking Personal Information
 */

class Solution {
    public String maskPII(String S) {
        if (S == null || S.length() == 0) return S;
        if (isEmail(S)) {
            return maskEmail(S);
        } else {
            return maskNum(S);
        }
    }

    public boolean isEmail(String s) {
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if ((c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z')) {
                return true;
            }
        }

        return false;
    }

    public String maskEmail(String s) {
        StringBuilder res = new StringBuilder();
        s = s.toLowerCase();
        char[] cs = s.toCharArray();

        int left = 0;
        int j = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '@') {
                left = i - j;
                j = i;
            }
        }


        res.append(cs[0]);
        for (int i = 0; i < 5; i++) {
            res.append('*');
        }

        res.append(cs[left - 1]);
        for (int i = left; i < cs.length; i++) {
            res.append(cs[i]);
        }

        return res.toString();
    }

    public String maskNum(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        String pre1 = "***-***-";
        String pre2 = "+*-***-***-";
        String pre3 = "+**-***-***-";
        String pre4 = "+***-***-***-";
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        if (sb.length() == 10) {
            res.append(pre1);
            res.append(sb.substring(6, 10));
            return res.toString();
        } else if (sb.length() == 11) {
            res.append(pre2);
            int size = sb.length();
            res.append(sb.substring(size - 4, size));
            return res.toString();
        } else if (sb.length() == 12) {
            res.append(pre3);
            int size = sb.length();
            res.append(sb.substring(size - 4, size));
            return res.toString();
        } else {
            res.append(pre4);
            int size = sb.length();
            res.append(sb.substring(size - 4, size));
            return res.toString();
        }
    }

    // Other's solution 1
    String[] country = {"", "+*-", "+**-", "+***-"};
    public String maskPII1(String S) {
        int at = S.indexOf("@");
        if (at > 0) {
            S = S.toLowerCase();
            return (S.charAt(0) + "*****" + S.substring(at - 1)).toLowerCase();
        }
        S = S.replaceAll("[^0-9]", "");
        return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
    }

}
