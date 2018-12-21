/**
 * Created on 21 Dec 2018 by happygirlzt
 *
 * LeetCode #419. Battleships in a Board
 *
 */

class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) return 0;
        int m = board.length, n = board[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (j != 0 && board[i][j - 1] == 'X') continue;
                if (i != 0 && board[i - 1][j] == 'X') continue;
                count++;
            }
        }

        return count;
    }
}
