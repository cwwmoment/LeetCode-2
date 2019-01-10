/**
 * Created on 10 Jan 2019 by happygirlzt
 *
 * LeetCode #794. Valid Tic-Tac-Toe State
 *
 */

class Solution {
    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0;
      /*  for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    x++;
                } else if (board[i].charAt(j) == 'O') {
                    o++;
                } else {
                    finished = false;
                }
            }
        }
        */

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') x++;
                else if (c == 'O') o++;
                else finished = false;
            }
        }

        if (x != o && x != o + 1) return false;
        if (win(board, 'X') && o != x - 1) return false;
        if (win(board, 'O') && o != x) return false;
        return true;
    }

    private boolean win(String[] b, char p) {
        for (int i = 0; i < 3; i++) {
            if (p == b[0].charAt(i) &&
               p == b[1].charAt(i) &&
               p == b[2].charAt(i)) {
                return true;
            }

            if (p == b[i].charAt(0) &&
               p == b[i].charAt(1) &&
               p == b[i].charAt(2)) {
                return true;
            }

            if (p == b[0].charAt(0) &&
               p == b[1].charAt(1) &&
               p == b[2].charAt(2)) {
                return true;
            }

            if (p == b[0].charAt(2) &&
               p == b[1].charAt(1) &&
               p == b[2].charAt(0)) {
                return true;
            }
        }
         return false;
    }
}
