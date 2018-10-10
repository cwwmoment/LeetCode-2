/**
 * Created on 10 Oct 2018 by happygirlzt
 *
 * LeetCode #85. Maximal Rectangle
 */

public class MaximalRectangle {
    // 这题好难，和之前那个直方图求最大面积差不多的思路
    // 但是这题更加复杂一点，就是说把以每一行为底部，然后
    // 计算每个点处的最高处，和这个高度能遍及的最左边
    // 和最右边+1，计算最大面积，就是底乘高，每次存起来
    // 周六的时候要汇总一下这类题
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
