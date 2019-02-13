/*
 * LeetCode #36 Valid Sudoku
 * happygirlzt
 * Created on 9 Aug 2018
 */
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> row = new HashSet<>();
			Set<Character> col = new HashSet<>();
			Set<Character> cube = new HashSet<>();
			
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}
				
				if (board[j][i] != '.' && !col.add(board[j][i])) {
					return false;
				}
				
				int rowIndex = 3 * (i / 3);
				int colIndex = 3 * (i % 3);
				
				if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
					return false;
				}
			}
		}
		
		return true;
	}

	// Updated on 13 Feb 2019
	public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                for (int k = 0; k < 9; k++) {
					// Must first guarantee that is not equal to .
                    if (k != i && board[k][j] != '.' && board[k][j] == c) return false;
                    if (k != j && board[i][k] != '.' && board[i][k] == c) return false;
					if (i != 3 * (i / 3) + k / 3 && j != 3 * (j / 3) + k % 3 
					&& board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] != '.' 
					&& board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) return false;
                }
            }
        }
        
        return true;
    }
}
