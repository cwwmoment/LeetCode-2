/**
 * Created on 18 Dec 2018 by happygirlzt
 *
 * LeetCode #51. N-Queens
 *
 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(res, board, 0);

        return res;
    }

    private void helper(List<List<String>> res, char[][] board, int row) {
        // base case
        if (row == board.length) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                helper(res, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        // check rows
        for (int k = 0; k < row; k++) {
            if (board[k][col] == 'Q') return false;
        }

        // check diagonose
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }


        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }

        return path;
    }

    // Updated on 21 Feb 2019
    public List<List<String>> solveNQueens1(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) return res;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        dfs(board, 0, new boolean[n], new boolean[n * 2 + 1], new boolean[n * 2 + 1], res);
        return res;
    }

    private void dfs(char[][] board, int row, boolean[] col, boolean[] left, boolean[] right, List<List<String>> res) {
        if (row == board.length) {
            addRes(board, res);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!col[i] && !left[i + row] && !right[i - row + board.length - 1]) {
                board[row][i] = 'Q';
                col[i] = true;
                left[i + row] = true;
                right[i - row + board.length - 1] = true;

                dfs(board, row + 1, col, left, right, res);

                board[row][i] = '.';
                col[i] = false;
                left[i + row] = false;
                right[i - row + board.length - 1] = false;
            }
        }
    }

    private void addRes(char[][] board, List<List<String>> res) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            tmp.add(sb.toString());
        }
        res.add(tmp);
    }

    // Updated on 26 Mar 2019
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        init(board, n);
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[n + n - 1];
        boolean[] antiDiag = new boolean[n + n - 1];
        helper(res, board, 0, cols, diag, antiDiag, n);
        return res;
    }

    private void init(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    private void helper(List<List<String>> res, char[][] board, int rowIndex, boolean[] cols, boolean[] diag, boolean[] antiDiag, int n) {
        if (rowIndex == n) {
            List<String> cur = turnToList(board, n);
            res.add(cur);
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (isValid(board, rowIndex, colIndex, cols, diag, antiDiag, n)) {
                board[rowIndex][colIndex] = 'Q';
                cols[colIndex] = true;
                diag[n - rowIndex + colIndex - 1] = true;
                antiDiag[rowIndex + colIndex] = true;
                helper(res, board, rowIndex + 1, cols, diag, antiDiag, n);
                board[rowIndex][colIndex] = '.';
                cols[colIndex] = false;
                diag[n - rowIndex + colIndex - 1] = false;
                antiDiag[rowIndex + colIndex] = false;
            }
        }
    }

    private boolean isValid(char[][] board, int rowIndex, int colIndex, boolean[] cols, boolean[] diag, boolean[] antiDiag, int n) {
        if (cols[colIndex] || diag[n - rowIndex + colIndex - 1] ||
            antiDiag[rowIndex + colIndex]) return false;
        return true;
    }

    private List<String> turnToList(char[][] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(board[i][j]);
            }
            res.add(row.toString());
        }
        return res;
    }
}
