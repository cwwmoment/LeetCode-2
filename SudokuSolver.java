
/*
 * LeetCode #37. Sudoku Solver
 * happygirlzt
 * Created on 10 Aug 2018
 */
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
	public int n;
	boolean[][] h = new boolean[9][10];
	boolean[][] v = new boolean[9][10];
	boolean[][] b = new boolean[9][10];

	public void solveSudoku(char[][] board) {
		n = board.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] != '.') {
					h[i][board[i][j] - '0'] = true;
					v[j][board[i][j] - '0'] = true;
					b[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
				}
			}
			solve(0, 0, board);
		}

	}

	boolean solve(int i, int j, char[][] a) {
		if (i == 9)
			return true;

		// the end of a line
		if (j == 9) {
			return solve(i + 1, 0, a);
		}

		if (a[i][j] != '.')
			return solve(i, j + 1, a);
		
		for (int k = 0; k < 9; k++) {
			if (!h[i][k] && !v[j][k] && !b[i / 3 * 3 + j / 3][k]) {
				a[i][j] = (char)('0' + k);
				h[i][k] = true;
				v[j][k] = true;
				b[i / 3 * 3 + j / 3][k] = true;
				
				if (solve(i, j + 1, a)) return true;
				
				h[i][j] = false;
				v[j][k] = false;
				b[i / 3 * 3 + j / 3][k] = false;
				a[i][j] = '.';
			}
		}
		
		return false;
	}
}
