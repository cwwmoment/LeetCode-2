/**
 * Created on 4 Dec 2018 by happygirlzt
 *
 * LeetCode #378. Kth Smallest Element in a Sorted Matrix
 *
 */

public class KthSmallestElementInASortedMatrix {
    // Binary search
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (matrix == null || n == 0) return -1;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = (low + high) >> 1;

            int count = 0;
            for (int[] i : matrix) {
                for (int j : i) {
                    if (j > mid) {
                        break;
                    }

                    count++;
                }
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
