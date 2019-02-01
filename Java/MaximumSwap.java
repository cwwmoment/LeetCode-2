/**
 * Created on 1 Feb 2019 by happygirlzt
 *
 * LeetCode #670. Maximum Swap
 *
 */

class Solution {
    public int maximumSwap(int num) {
        char[] a = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];
        for (int i = 0; i < a.length; i++) {
            lastIndex[a[i] - '0'] = i;
        }

        for (int i = 0; i < a.length; i++) {
            for (int d = 9; d > a[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    swap(a, lastIndex[d], i);
                    return Integer.parseInt(String.valueOf(a));
                }
            }
        }
        return num;
    }

    private void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
