/**
 * Created on 21 Feb 2019 by happygirlzt
 * 
 * LeetCode #52. N-Queens II
 */

class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        dfs(board, 0, new boolean[n], new boolean[n * 2 + 1], new boolean[n * 2 + 1]);
        return count;
    }
    
    private void dfs(char[][] board, int row, boolean[] col, boolean[] left, boolean[] right) {
        if (row == board.length) {
            count++;
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (!col[i] && !left[i + row] && !right[i - row + board.length - 1]) {
                board[row][i] = 'Q';
                col[i] = true;
                left[i + row] = true;
                right[i - row + board.length - 1] = true;
                
                dfs(board, row + 1, col, left, right);
                board[row][i] = '.';
                col[i] = false;
                left[i + row] = false;
                right[i - row + board.length - 1] = false;
            }
        }
    }
}