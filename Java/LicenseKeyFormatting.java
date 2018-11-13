/**
 * Created on 13 Nov 2018 by happygirlzt
 *
 * LeetCode #482. License Key Formatting
 *
 */

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) return "";
        String[] splited = S.split("-");
        String t = "";

        if (splited == null || splited.length == 0) return "";
        for (String s : splited) {
            t += s;
        }

        t = t.toUpperCase();
        int len = t.length();
        int re = len % K;
        int count = len / K;

        StringBuilder res = new StringBuilder();
        char[] cs = t.toCharArray();

        for (int i = 0; i < re; i++) {
            res.append(cs[i]);
        }
        if (re != 0) res.append('-');

        for (int j = 0; j < count; j++) {
            for (int h = re + j * K; h < K + re + K * j; h++) {
                res.append(cs[h]);
            }
            res.append('-');
        }

        String r = res.toString();
        if (r.charAt(r.length() - 1) == '-') return r.substring(0, r.length() - 1);

        return r;
    }

    public String licenseKeyFormatting1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }
}
