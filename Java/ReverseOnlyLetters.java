/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #917. Reverse Only Letters
 *
 */

class Solution {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return S;

        char[] cs = S.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i <= j) {
            if (Character.isLetter(cs[i]) && Character.isLetter(cs[j])) {
                swap(cs, i, j);
                i++;
                j--;
            } else if (Character.isLetter(cs[i])) {
                j--;
            } else if (Character.isLetter(cs[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return new String(cs);
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
