/**
 * Created on 8 Jan 2019 by happygirlzt
 *
 * LeetCode #529. Minesweeper
 *
 */

class Solution {
    private int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        dfs(board, row, col);
        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        if (calMines(board, row, col) > 0) {
            board[row][col] = (char) (calMines(board, row, col) + '0');
        } else {
            board[row][col] = 'B';
            for (int[] dir : dirs) {
                int r = dir[0] + row;
                int c = dir[1] + col;
                if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1) continue;
                if (board[r][c] == 'E') dfs(board, r, c);
            }
        }
    }

    private int calMines(char[][] board, int row, int col) {
        int count = 0;

        for (int[] dir : dirs) {
            int r = dir[0] + row;
            int c = dir[1] + col;
            if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1) continue;
            if (board[r][c] == 'M' || board[r][c] == 'X') count++;
        }

        return count;
    }
}
