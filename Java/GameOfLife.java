/**
 * Created on 30 Nov 2018 by happygirlzt
 *
 * LeetCode #289. Game of Life
 *
 */

public class GameOfLife {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0},
                            {-1, 1}, {-1, 0}, {-1, -1}};

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;

        int row = board.length, col = board[0].length;
        int[][] next = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                detect(board, i, j, next);
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(next[i], 0, board[i], 0, next[i].length);
        }
    }

    public void detect(int[][] b, int r, int l, int[][] next) {
        int count = 0;
        for (int[] dir : dirs) {
            if (r + dir[0] < 0 || r + dir[0] >= b.length ||
                l + dir[1] < 0 || l + dir[1] >= b[0].length) continue;

            if (b[r + dir[0]][l + dir[1]] == 1) {
                count++;
            }
        }

        if (b[r][l] == 1) {
            if (count < 2) {
                next[r][l] = 0;
            } else if (count == 2 || count == 3) {
                next[r][l] = 1;
            } else if (count > 3) {
                next[r][l] = 0;
            }
        } else {
            if (count == 3) {
                next[r][l] = 1;
            }
        }
    }
}
