/**
 * Modified on 3 Feb 2019 by happygirlzt
 *
 * LeetCode #28. Implement strStr()
 *
 */

public class ImplementStrStr {
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

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";

        System.out.println(strStr(s1, s2));
    }
}
