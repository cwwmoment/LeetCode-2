/*
 * LeetCode #37. Sudoku Solver
 *
 * Modified on 4 Dec 2018
 *
 * Created on 10 Aug 2018 by happygirlzt
 *
 */


public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][9];
        boolean[][] colUsed = new boolean[9][9];
        boolean[][] gridUsed = new boolean[9][9];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    rowUsed[i][board[i][j] - '1'] = true;
                    colUsed[j][board[i][j] - '1'] = true;

                    int gridNum = i / 3 * 3 + j / 3;
                    gridUsed[gridNum][board[i][j] - '1'] = true;
                }
            }
        }

        fill(board, rowUsed, colUsed, gridUsed, 0);
    }

    public boolean fill(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][] gridUsed, int i){
        if (i == 81) {
            return true;
        }

        int x = i / 9;
        int y = i % 9;

        if (board[x][y] != '.') {
            return fill(board, rowUsed, colUsed, gridUsed, i + 1);
        }

        for(int k = 1; k <= 9; k++){
            if (!rowUsed[x][k - 1] && !colUsed[y][k - 1] && !gridUsed[x / 3 * 3 + y / 3][k - 1]) {
                board[x][y] = (char)(k + '0');
                rowUsed[x][k - 1] = true;
                colUsed[y][k - 1] = true;
                gridUsed[x / 3 * 3 + y / 3][k - 1] = true;

                if (fill(board, rowUsed, colUsed, gridUsed, i + 1)) {
                    return true;
                }

                board[x][y] = '.';
                rowUsed[x][k - 1] = false;
                colUsed[y][k - 1] = false;
                gridUsed[x / 3 * 3 + y / 3][k - 1] = false;
            }
        }

        return false;
    }
}
