/**
 * Created on 18 Feb 2019 by happygirlzt
 *
 * LeetCode #977. Squares of a Sorted Array
 *
 */

// O(N), O(N)
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0, j = 0;

        for (i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                j = i - 1;
                break;
            }
        }

        int index = 0;
        while (j >= 0 && i < A.length) {
            if (A[j] * A[j] < A[i] * A[i]) {
                res[index++] = A[j] * A[j];
                j--;
            } else {
                res[index++] = A[i] * A[i];
                i++;
            }
        }

        while (j >= 0) {
            res[index++] = A[j] * A[j--];
        }

        while (i < A.length) {
            res[index++] = A[i] * A[i++];
        }

        return res;
    }

    // Updated on 3 Mar 2019
    public int[] sortedSquares1(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;

        int index = n - 1;
        while (i <= j) {
            if (A[i] * A[i] >= A[j] * A[j]) {
                res[index--] = A[i] * A[i];
                i++;
            } else {
                res[index--] = A[j] * A[j];
                j--;
            }
        }

        return res;
    }
}
