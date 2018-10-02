/**
 * Created on 2 Oct 2018 by happygirlzt
 *
 * LeetCode #647. Palindromic Substrings
 */

public class PalindromicSubstrings {
    // 竟然过了！！！好开心，明明我好困.虽然这个做法挺蠢的，但是很简单呀
    // 注意点是，如果新增一个字母，可能会增加回文子串的个数，但是起点不一定是index为0的地方
    public boolean isPalin(char[] cs, int start, int end) {
        int low = start, high = end;
        while (low <= high) {
            if (cs[low] != cs[high]) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }

    public int count(char[] cs, int index) {
        int res = 0;

        for (int i = 0; i < index; i++) {
            if (isPalin(cs, i, index)) {
                System.out.println(i + " " + index);
                res++;
            }
        }

        System.out.println(res);
        return res;
    }

    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return 1;

        char[] cs = s.toCharArray();

        int[] dp = new int[len+1];
        dp[0] = 0;

        for (int i = 1; i < len; i++) {
            dp[i+1] = count(cs, i) + dp[i];
        }

        dp[len] += len;
        return dp[len];
    }

    // 别人的优秀的做法
    // 这个做法其实是分为奇数和偶数，从中心扩散
    int count = 0;
    public int countSubstrings1(String s) {
        if (s == null || s.isEmpty()) return 0;

        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);  // odd length
            helper(s, i, i + 1);  // even length
        }

        return count;
    }

    private void helper(String s, int low, int high) {
        while (low >= 0 && low <= high && high < s.length() && s.charAt(low) == s.charAt(high)) {
            count++;
            low--;
            high++;
        }
    }
}
