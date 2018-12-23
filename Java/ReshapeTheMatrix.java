/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #566. Reshape the Matrix
 *
 */

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) return nums;

        int m = nums.length, n = nums[0].length;
        int[][] res = new int[r][c];
        int len = m * n;
        if (len != r * c) return nums;
        int[] tmp = new int[len];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j + i * n] = nums[i][j]; // Attention!!! it is n, not j
            }
        }

        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = tmp[k++];
            }
        }

        return res;
    }

    // Save the tmp matrix
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) return nums;

        int m = nums.length, n = nums[0].length;
        int[][] res = new int[r][c];
        int len = m * n;
        if (len != r * c) return nums;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }

        return res;
    }
}
