/**
 * LeetCode #240. Search a 2D Matrix II
 *
 * Created by happygirlzt on 30 Aug 2018 at 9:17:45 PM
 *
 */

public class Search2DMatrix2 {
    /**
     * 这题一看题目就知道是二分搜索。。 先判断那几行不可能，然后在可能的那几行里再做二分搜索
     * 耶，过了！敲开心。。看了discuss，再次感到了智商碾压。。
     * My naive solution
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int top = 0, down = rowNum - 1;
        int left = 0, right = colNum - 1;

        // 找出有可能的几行，binary search
        while (matrix[down][0] >= target && matrix[top][0] <= target) {
            int midRow = (top + down) >> 1;
            if (matrix[midRow][0] < target) {
                top = midRow + 1;
            } else if (matrix[midRow][0] == target) {
                return true;
            } else {
                down = midRow - 1;
            }
        }

        if (matrix[top][0] > target) {
            down = top - 1;
            top = 0;
        }

        System.out.println("down = " + down);
        // 找出可能的几列
        while (matrix[0][left] <= target && matrix[0][right] >= target) {
            int midCol = (left + right) >> 1;
            if (matrix[0][midCol] < target) {
                left = midCol + 1;
            } else if (matrix[0][midCol] == target) {
                return true;
            } else {
                right = midCol - 1;
            }
        }

        if (matrix[0][left] > target) {
            right = left - 1;
            left = 0;
        }

        System.out.println("right = " + right);
        // 现在得到的有效范围是matrix[1~down][1~right]

        left = 1; top = 1;
        int r = right;
        if (down != 0 && right != 0) {
            for (int j = 1; j <= down; j++) {
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    System.out.println("mid = " + mid);
                    System.out.println("matrix[j][mid] = " + matrix[j][mid]);
                    if (matrix[j][mid] < target) {
                        left = mid + 1;
                    } else if (matrix[j][mid] == target) {
                        return true;
                    } else {
                        right = mid - 1;
                    }
                }
                if (j <= down) {
                    left = 1; right = r;
                }
            }
        }

        return false;
    }

    // Other's talented solution
    // 感觉被碾压了，其实是找规律。起始的列不是从0开始，要从最右边开始。。
    // 如果matirx[0][matrix[0].length-1]的值比target大，那么col--，因为整个列都比target大
    // 如果matrix[0][matrix[0].length-1]的值比target小，那么row++，因为整个列都比target小
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(searchMatrix(nums, 25));
    }
}
