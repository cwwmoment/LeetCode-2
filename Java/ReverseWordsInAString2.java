/**
 * Created on 10 Jan 2019 by happygirlzt
 *
 * LeetCode #186. Reverse Words in a String II
 *
 */

class Solution {
    public void reverseWords(char[] str) {
        int len = str.length;
        int i = 0, j = len - 1;
        reverse(str, i, j);

        int end = 0;
        for (int start = 0; start < len; i++) {
            while (end < len && str[end] != ' ') {
                end++;
            }

            if (end < len - 1) reverse(str, start, end - 1);
            if (end > len - 1) reverse(str, start, len - 1);
            start = end + 1;
            end++;
        }
    }

    // Little modification
    public void reverseWords1(char[] str) {
        reverse(str, 0, str.length - 1);

        for (int start = 0, end = 0; end <= str.length; end++) {
            if (end == str.length || str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
    }

    private void swap(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    private void reverse(char[] word, int i, int j) {
        int len = word.length;
        while (i <= j) {
            swap(word, i++, j--);
        }
    }
}
