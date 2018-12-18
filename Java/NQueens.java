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
}
