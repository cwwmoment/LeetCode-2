/**
 * Created on 5 Dec 2018 by happygirlzt
 *
 * LeetCode #905. Sort Array By Parity
 *
 */

class Solution {
    public int[] sortArrayByParity(int[] a) {
        int len = a.length;

        int left = 0, right = len - 1;

        while (left < right) {
            while (left < right && a[left] % 2 == 0) {
                left++;
            }

            while (left < right && a[right] % 2 != 0) {
                right--;
            }


            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }

        return a;
    }

    // Updated on 19 Mar 2019
    public int[] sortArrayByParity1(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        for (int index = 0; index < n; index++) {
            if (A[index] % 2 == 0) {
                res[i++] = A[index];
            } else {
                res[j--] = A[index];
            }
        }

        return res;
    }
}
