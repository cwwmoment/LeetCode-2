/**
 * Created on 10 Oct 2018 by happygirlzt
 *
 * LeetCode #85. Maximal Rectangle
 */

public class MaximalRectangle {
    // Updated on 12 Apr 2019
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] grid = new int[matrix.length][matrix[0].length];
        buildHistogram(matrix, grid);
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, maxRec(grid, i, matrix[i].length));
        }
        return max;
    }

    private void buildHistogram(char[][] matrix, int[][] grid) {
        for (int j = 0; j < matrix[0].length; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                grid[i][j] += matrix[i][j] == '0' ? 0 : grid[i - 1][j] + 1;
            }
        }
    }

    private int maxRec(int[][] grid, int bottom, int n) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int curIndex = 0;

        while (curIndex < n) {
            while (stack.peek() != -1 && grid[bottom][curIndex] <= grid[bottom][stack.peek()]) {
                max = Math.max(max, grid[bottom][stack.pop()] * (curIndex - stack.peek() - 1));
            }

            stack.push(curIndex++);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, grid[bottom][stack.pop()] * (curIndex - stack.peek() - 1));
        }

        return max;
    }

    public int maximalRectangle(char[][] m) {
        if (m == null || col == 0) return 0;

        int row = m.length;
        int col = m[0].length;

        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];

        int max = 0;

        Arrays.fill(right, col);

        for (int i = 0; i < row; i++) {
            int cur_left = 0, cur_right = col;

            for (int j = 0; j < col; j++) {
                if (m[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < col; j++) {
                if (m[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }

            for (int j = col - 1; j >= 0; j--) {
                if (m[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = col;
                    cur_right = j;
                }
            }

            for (int j = 0; j < col; j++) {
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }

        return max;
    }
}
