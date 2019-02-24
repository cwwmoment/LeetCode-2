/**
 * Created on 24 Feb 2019 by happygirlzt
 * 
 * LeetCode #997. Find the Town Judge
 */

class Solution {
    private final int[] r = {1, -1, 0, 0};
    private final int[] c = {0, 0, 1, -1};

    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0) return 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    return helper(board, i, j);
                }
            }
        }
        return 0;
    }
    
    private int helper(char[][] board, int i, int j) {          
        int count = 0;
            for (int k = 0; k < 4; k++) {
                int rr = i + r[k];
                int cc = j + c[k];

                while (isValid(rr, cc, board) && 
                       board[rr][cc] == '.') {
                    rr += r[k];
                    cc += c[k];
                }
                
                
                if ((isValid(rr, cc, board) && board[rr][cc] == 'p') || (
                isValid(rr - r[k], cc - c[k], board) && 
                board[rr - r[k]][cc - c[k]] == 'p')) {

                    count++;
                }
            }
        
        return count;
    }

    private boolean isValid(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return false;
        return true;
    }
}