/**
 * Created on 7 Oct 2018 by happygirlzt
 *
 * LeetCode #409. Longest Palindrome
 */

import java.util.Map.Entry;

public class LongtestPalindrome {
    // 我的很简单的解法
    public int longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return len;

        HashMap<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();

        for (int i = 0; i < len; i++) {
            if (!map.containsKey(cs[i])) {
                map.put(cs[i], 1);
            } else {
                int tmp = map.get(cs[i]);
                map.put(cs[i], ++tmp);
            }
        }

        if (map.size() == 1) return len;

        int res = 0;
        boolean flag = false;
        for (Entry<Character, Integer> entry: map.entrySet()) {
            int t = entry.getValue();
            if (t % 2 == 0) {
                res += t;
            } else if (t > 2 && flag == false) {
                res += t;
                flag = true;
            } else if (t > 2) {
                res += t / 2 * 2;
            } else if (t == 1 && flag == false) {
                res += 1;
                flag = true;
            }
        }

        return res;
    }

    // Other's smart solution
    public int longestPalindrome1(String s) {
        int len = 0;
        int[] count = new int[128];
        char[] cs = s.toCharArray();

        for (char c : cs) {
            count[c]++;
        }

        for (int n : count) {
            len += n / 2 * 2;
            if (n % 2 == 1 && len % 2 == 0) len++;
        }

        return len;
    }
}
