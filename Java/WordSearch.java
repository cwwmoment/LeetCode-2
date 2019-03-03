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

        b[i][j] ^= 256;
        if (dfs1(b, cs, i + 1, j, count + 1)) return true;
        if (dfs1(b, cs, i - 1, j, count + 1)) return true;
        if (dfs1(b, cs, i, j + 1, count + 1)) return true;
        if (dfs1(b, cs, i, j - 1, count + 1)) return true;

        b[i][j] ^= 256;
        return false;
    }

    // Updated on 27 Feb 2019
    /**
     * 这题是backtracking，而不是普通的dfs，choose完要unchoose，因为这样在下个点
     * 还能继续搜索。如果不unchoose就会找不到。每次的visited，其实只能在一次搜索的
     * 时候用。
     * Time: 4^N*N^2,最坏情况就是搜索完整个board，达到每个board的最大深度
     */
    public boolean exist2(char[][] board, String word) {
        if (board == null || word == null) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, 0, i, j, visited)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int r, int c, boolean[][] visited) {
        if (index == word.length()) return true;

        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1) return false;
        if (visited[r][c]) return false;
        if (word.charAt(index) != board[r][c]) return false;

        visited[r][c] = true;
        if (dfs(board, word, index + 1, r + 1, c, visited) ||
            dfs(board, word, index + 1, r - 1, c, visited) ||
            dfs(board, word, index + 1, r, c + 1, visited) ||
            dfs(board, word, index + 1, r, c - 1, visited)) return true;
        visited[r][c] = false;
        return false;
    }

    // Updated on 3 Mar 2019
    public boolean exist3(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) return true;
        if (row < 0 || row > board.length - 1 ||
           col < 0 || col > board[0].length - 1) return false;
        if (word.charAt(index) != board[row][col]) return false;

        char c = board[row][col];
        board[row][col] = '#';
        if (dfs(board, row + 1, col, word, index + 1) ||
           dfs(board, row - 1, col, word, index + 1) ||
           dfs(board, row, col + 1, word, index + 1) ||
           dfs(board, row, col - 1, word, index + 1)) return true;
        board[row][col] = c;
        return false;
    }

}
