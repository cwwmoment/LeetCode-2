/**
 * LeetCode #79. Word Search
 * 
 * Created by happygirlzt on 31 Aug 2018 at 10:54:17 AM
 *
 */

public class WordSearch {
	private static boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;

		int rowNum = board.length;
		int colNum = board[0].length;

		visited = new boolean[rowNum][colNum];

		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0))
					return true;
			}
		}

		return false;
	}

	public boolean dfs(char[][] board, String word, int i, int j, int k) {
		if (k == word.length())
			return true;
		
		// Out of bound
		if (i > board.length - 1 || j > board[0].length - 1 || i < 0 || j < 0 ||
				visited[i][j] || board[i][j] != word.charAt(k)) {
			return false;
		}
		
		visited[i][j] = true;

		if (dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1)
				|| dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i, j - 1, k + 1))
			return true;

		visited[i][j] = false;
		return false;
	}
}
