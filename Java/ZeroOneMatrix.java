/**
 * Created on 4 Nov 2018 by happygirlzt
 *
 * LeetCode #542. 01 Matrix
 *
 */

public class ZeroOneMatrix {
    private class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return matrix;

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        boolean[][] visited = new boolean[rowNum][colNum];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new Point(i, j));
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            int row = p.x;
            int col = p.y;

            if (row + 1 < rowNum && matrix[row + 1][col] > matrix[row][col]) {
                q.offer(new Point(row + 1, col));
                matrix[row + 1][col] = matrix[row][col] + 1;
            }

            if (row - 1 >= 0 && matrix[row - 1][col] > matrix[row][col]) {
                q.offer(new Point(row - 1, col));
                matrix[row - 1][col] = matrix[row][col] + 1;
            }

            if (col + 1 < colNum && matrix[row][col + 1] > matrix[row][col]) {
                q.offer(new Point(row, col + 1));
                matrix[row][col + 1] = matrix[row][col] + 1;
            }

            if (col - 1 >= 0 && matrix[row][col - 1] > matrix[row][col]) {
                q.offer(new Point(row, col - 1));
                matrix[row][col - 1] = matrix[row][col] + 1;
            }
        }

        return matrix;
    }
}
