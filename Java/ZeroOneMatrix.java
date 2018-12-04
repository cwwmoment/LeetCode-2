/**
 * Created on 4 Nov 2018 by happygirlzt
 *
 * Modified on 4 Dec 2018
 *
 * LeetCode #542. 01 Matrix
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
    
    // Updated on 4 Dec
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int[][] updateMatrix1(int[][] m) {
        if (m == null || m.length == 0) return m;
        int row = m.length, col = m[0].length;
        int[][] dis = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m[i][j] == 0) {
                 dis[i][j] = 0;
                } else {
                bfs(m, dis, i, j);
              }
            }
            
        }
        
        return dis;
    }
    
    public void bfs(int[][] m, int[][] dis, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            
            int size = q.size();
                            
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();  
                
                for (int[] dir : dirs) { 
                    int newr = cur[0] + dir[0];
                    int newc = cur[1] + dir[1];

                    if (newr < 0 ||
                       newr > m.length - 1 ||
                       newc < 0 ||
                       newc > m[0].length - 1) continue;

                    if (m[newr][newc] == 0) {
                        dis[r][c] = count;
                        return;
                    } else {
                        q.offer(new int[]{newr, newc});
                    }
             } 
           }         
        }        
    }
}
