/**
 * Created on 19 Apr 2019 by happygirlzt
 *
 * LeetCode #840. Magic Squares In Grid
 *
 */

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagic(grid, i, i + 2, j, j + 2)) {

                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagic(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        boolean[] used = new boolean[10];
        Set<Integer> rows = new HashSet<>();
        for (int i = rowStart; i <= rowEnd; i++) {
            int rowSum = 0;
            for (int j = colStart; j <= colEnd; j++) {
                if (grid[i][j] > 9 || grid[i][j] < 1) return false;
                if (used[grid[i][j]]) return false;
                used[grid[i][j]] = true;
                rowSum += grid[i][j];
            }
            rows.add(rowSum);
        }

        for (int j = colStart; j <= colEnd; j++) {
            int colSum = 0;
            for (int i = rowStart; i <= rowEnd; i++) {
                colSum += grid[i][j];
            }
            rows.add(colSum);
        }

        int diagSum = grid[rowStart][colStart] + grid[rowStart + 1][colStart + 1] + grid[rowEnd][colEnd];
        int antiDiagSum = grid[rowStart][colEnd] + grid[rowStart + 1][colStart + 1] + grid[rowEnd][colStart];

        return rows.size() == 1 &&
            rows.contains(diagSum) && rows.contains(antiDiagSum);
    }
}
