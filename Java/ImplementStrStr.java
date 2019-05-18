/**
 * Modified on 3 Feb 2019 by happygirlzt
 *
 * LeetCode #28. Implement strStr()
 *
 */

public class ImplementStrStr {
    // Updated on 28 May 2019
    // KMP Algorithm
    public int strStr(String t, String p) {
        int n = t.length();
        int m = p.length();
        if (m == 0) return 0;

        int[] pi = new int[m];
        computePrefix(p, pi);

        int k = -1;
        for (int i = 0; i < n; i++) {
            while (k >= 0 && p.charAt(k + 1) != t.charAt(i)) {
                k = pi[k];
            }

            if (p.charAt(k + 1) == t.charAt(i)) {
                k++;
            }

            if (k == m - 1) {
                return i - m + 1;
            }
        }

        return -1;
    }

    private void computePrefix(String p, int[] pi) {
        pi[0] = -1;
        int k = -1;
        int m = p.length();
        for (int i = 1; i < m; i++) {
            while (k >= 0 && p.charAt(k + 1) != p.charAt(i)) {
                k = pi[k];
            }

            if (p.charAt(k + 1) == p.charAt(i)) {
                k++;
            }

            pi[i] = k;
        }
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack == null || haystack.length() == 0)
            return -1;

        int hayLen = haystack.length();
        int needLen = needle.length();

        for (int i = 0; i < needLen; i++) {
            for (int j = 0; j < hayLen - needLen; j++) {
                return i;
            }
        }
        return -1;
    }

    // Updated on 3 Mar 2019
    public int strStr(String hayStack, String needle) {
        if (needle.isEmpty()) return 0;

        for (int i = 0; i <= hayStack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length() && hayStack.charAt(i + j) == needle.charAt(j); j++) {
                if (j == needle.length() - 1) return i;
            }
        }

        return -1;
    }
}
