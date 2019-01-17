import java.util.Arrays;
import java.lang.StringBuilder;
/*
 * LeetCode #14 Longest Common Prefix
 * happygirlzt
 * 2018/7/24
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        if (strs.length == 0 || strs == null) return "";
        // Sort the array first and compare the first and last one
        Arrays.sort(strs);

        StringBuilder res = new StringBuilder("");

        int size = strs.length;
        int len = Math.min(strs[0].length(), strs[1].length());

        for (int i = 0; i < len; i++) {
            if (strs[0].charAt(i) == strs[size-1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else {
                return res.toString();
            }
        }

        return res.toString();
    }

    // Updated on 17 Jan 2019
    public String longestCommonPrefix(String[] strs) {
        // corner case
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // border check
                if (i == strs[j].length || strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }
}
