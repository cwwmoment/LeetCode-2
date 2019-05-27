/*
 * LeetCode
 * happygirlzt
 * Created on 6 Aug 2018
 */
public class Search2DMatrix {
    // Updated on 27 May 2019
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (matrix[mid / n][mid % n] == target) {
                return true;
            }

            if (matrix[mid / n][mid % n] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, down = matrix.length - 1;
        int mid = (top + down) / 2;
        while (matrix[mid][0] != target) {
            if (target > matrix[mid][0] && target < matrix[mid + 1][0]) {
                for (int i = 0; i < matrix[mid].length; i++) {
                    if (target == matrix[mid][i]) {
                        return true;
                    }
                }
                return false;
            } else if (target < matrix[mid][0] && target > matrix[mid - 1][0]) {
                for (int j = 0; j < matrix[mid].length; j++) {
                    if (target == matrix[mid - 1][j]) {
                        return true;
                    }
                }
                return false;
            } else if (target > matrix[mid][0]) {
                top = mid;
                mid = (top + down) / 2;
            } else if (target < matrix[mid][0]) {
                down = mid;
                mid = (top + down) / 2;
            }
        }

        return true;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid / col_num][mid % col_num];

            if (mid_value == target) {
                return true;

            } else if (mid_value < target) {
                begin = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

        System.out.println(searchMatrix(m, 30));
    }
}
