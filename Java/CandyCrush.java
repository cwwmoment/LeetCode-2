/**
 * Created on 10 Jan 2019 by happygirlzt
 *
 * LeetCode #723. Candy Crush
 *
 */

class Solution {
    public int[][] candyCrush(int[][] b) {
        int row = b.length, col = b[0].length;
        boolean todo = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j + 2 < col; j++) {
                int value = Math.abs(b[i][j]);
                if (value != 0 && value == Math.abs(b[i][j + 1])
                    && value == Math.abs(b[i][j + 2])) {
                    b[i][j] = b[i][j + 1] = b[i][j + 2] = -value;
                    todo = true;
                }
            }
        }

        for (int i = 0; i + 2 < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = Math.abs(b[i][j]);
                if (value != 0 && value == Math.abs(b[i + 1][j])
                    && value == Math.abs(b[i + 2][j])) {
                    b[i][j] = b[i + 1][j] = b[i + 2][j] = -value;
                    todo = true;
                }
            }
        }

        for (int j = 0; j < col; j++) {
            int side = row - 1;

            for (int i = row - 1; i >= 0; i--) {
                if (b[i][j] > 0) {
                    b[side--][j] = b[i][j];
                }
            }

            while (side >= 0) {
                b[side--][j] = 0;
            }
        }

        return todo ? candyCrush(b) : b;
    }
}
