/*
 * LeetCode #5: Longest Palindromic Substring
 * @author happygirlzt
 * 2018/7/23
 */

public class LongestPalindromicSubstring {

    // Solution 1: Dynamic Programming
    public static String longestPalindrome(String s) {
        String res = null;
        if (s == null | s.length() <= 1)
            return s;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Length = 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;
        // Length = 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                start = i;
            }
        }

        // Length >= 3
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                // System.out.println("i = " + i);
                int j = i + k - 1;

                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    maxLen = k;
                    start = i;
                    dp[i][j] = true;
                    // System.out.println("maxLen = " + maxLen);
                    // System.out.println("Start from " + start);
                }
            }
        }

        res = s.substring(start, start + maxLen);
        return res;
    }

    // Solution 2
    private static int start, maxLength;

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            helper(s, i, i); // odd
            helper(s, i, i + 1); // even
        }

        return s.substring(start, start + maxLength);
    }

    public static void helper(String s, int l, int r) {
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        if (maxLength < r - l - 1) {
            start = l + 1;
            maxLength = r - l - 1;
        }
    }

    public static void main(String[] args) {
        String a = "abcba";
        System.out.println(longestPalindrome(a));
    }

    // 2 Oct 2018 二刷
    int max = 0, beg = 0;
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i+1);
        }

        return s.substring(beg, beg + max + 1);
    }

    private static void extend(String s, int start, int end) {
        while (start >= 0 && end < s.length() && start < end && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        if (max < end - start - 1) {
            beg = start + 1;
            max = end - start - 1;
        }
    }
}
