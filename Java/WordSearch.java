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

    // Updated on 4 Dec 2018
     public boolean exist(char[][] b, String w) {
        if (b == null || b.length == 0) return false;
        char[] cs = w.toCharArray();
        int row = b.length, col = b[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (b[i][j] == cs[0]) {
                    if (dfs(b, cs, i, j, 0)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs1(char[][] b, char[] cs, int i, int j, int count) {

        if (count == cs.length) return true;
        if (i < 0 || i >= b.length ||
           j < 0 || j >= b[0].length ||
           cs[count] != b[i][j]) return false;


            //System.out.println(b[i][j]);

//            count++;

        b[i][j] ^= 256;
            if (dfs1(b, cs, i + 1, j, count + 1)) return true;
            if (dfs1(b, cs, i - 1, j, count + 1)) return true;
            if (dfs1(b, cs, i, j + 1, count + 1)) return true;
            if (dfs1(b, cs, i, j - 1, count + 1)) return true;

        b[i][j] ^= 256;
        return false;
    }
}
