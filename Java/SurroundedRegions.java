/**
 * Created on 4 Nov 2018 by happygirlzt
 *
 * LeetCode #130. Surrounded Regions
 *
 */

public class SurroundedRegions {
    private class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rowNum = board.length;
        int colNum = board[0].length;

        Queue<Point> q = new LinkedList<>();
        // check the 'O' in the borders
        for (int i = 0; i < colNum; i++) {
            if (board[0][i] == 'O' ) {
                board[0][i] = '+';
                q.offer(new Point(0, i));
            }
        }

        for (int i = 0; i < rowNum; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '+';
                q.offer(new Point(i, 0));
            }
        }

        for (int i = 0; i < colNum; i++) {
            if (board[rowNum - 1][i] == 'O' ) {
                board[rowNum - 1][i] = '+';
                q.offer(new Point(rowNum - 1, i));
            }
        }

        for (int i = 0; i < rowNum; i++) {
            if (board[i][colNum - 1] == 'O' ) {
                board[i][colNum - 1] = '+';
                q.offer(new Point(i, colNum - 1));
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            int row = p.x;
            int col = p.y;

            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '+';
                q.offer(new Point(row - 1, col));
            }

            if (row + 1 < rowNum && board[row + 1][col] == 'O') {
                board[row + 1][col] = '+';
                q.offer(new Point(row + 1, col));
            }

            if (col + 1 < colNum && board[row][col + 1] == 'O') {
                board[row][col + 1] = '+';
                q.offer(new Point(row, col + 1));
            }

            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = '+';
                q.offer(new Point(row, col - 1));
            }
        }

        // flip
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else  if (board[i][j] == '+' ) {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // Modified on 5 Nov 2018
    // TODO: buggy
    public static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix1(int[][] matrix) {
        if (matrix == null || matrix.length == 1) return matrix;

        int m = matrix.length, n = matrix[0].length;
        // int[][] res = new int[m][n];

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new Point(i, j));
                    // matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int[] dir: dirs) {
                int row = p.x + dir[0];
                int col = p.y + dir[1];

                if (row < 0 || col < 0 || row >= m || col >= n || matrix[row][col] <= matrix[p.x][p.y] + 1) continue;

                // res[row][col] += 1;
                q.offer(new Point(row, col));
                res[row][col] = matrix[p.x][p.y] + 1;
            }
        }

        return matrix;
    }
}
