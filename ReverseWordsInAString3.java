/**
 * Created on 28 Sep 2018 by happygirlzt
 *
 * LeetCode #557. Reverse Words in a String III
 */

public class ReverseWordsInAString3 {

    // 我的写法
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ' ') {
                r = i;
                if (i == cs.length - 1) {
                    reverse(cs, l, r);
                }
            } else {
                System.out.println("l = " + l + "r = " + r);
                reverse(cs, l, r);
                l = r + 2;
            }
        }

        String res = String.valueOf(cs);

        return res;
    }

    void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    // 别人的稍微简洁一点的写法
    public String reverseWords1(String s) {
        char[] cs = s.toCharArray();
        int left = 0, right = 0, n = s.length();
        while (left < n && right < n) {
            while (right < n && cs[right] != ' ') {
                right++;
            }

            for (int i = left, j = right - 1; i < j; i++, j--) {
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
            }

            right++;
            left = right;
        }

        return new String(cs);
    }
}
