/**
 * Created on 6 Oct 2018 by happygirlzt
 *
 * LeetCode #59. Spiral Matrix II
 */

public class SpiralMatrix2 {
    // 螺旋矩阵就是个模板题。。熟悉这个坐标的操作就可以了
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int beg = 1;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[up][i] = beg++;
            }
            up++;

            for (int i = up; i <= down; i++) {
                res[i][right] = beg++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                res[down][i] = beg++;
            }
            down--;

            for (int i = down; i >= up; i--) {
                res[i][left] = beg++;
            }
            left++;

            if (up >= down && left >= right) {
                if (up == down && left == right) {
                    res[up][left] = beg++;
                }
                break;
            }
        }

        return res;
    }
}
