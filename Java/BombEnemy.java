/**
 * Created on 27 Mar 2019 by happygirlzt
 *
 * LeetCode #361. Bomb Enemy
 *
 */

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int rowCount = 0;
        int[] colCount = new int[cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCount[j] = 0;
                    for (int k = i; k < rows && grid[k][j] != 'W'; k++) {
                        colCount[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }

                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = 0;
                    for (int k = j; k < cols && grid[i][k] != 'W'; k++) {
                        rowCount += grid[i][k] == 'E' ? 1 : 0;
                    }
                }

                if (grid[i][j] == '0') {
                    res = Math.max(res, rowCount + colCount[j]);
                }
            }
        }

        return res;
    }
}
