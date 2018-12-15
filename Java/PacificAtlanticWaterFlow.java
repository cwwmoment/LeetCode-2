/**
 * Created on 15 Dec 2018 by happygirlzt
 *
 * LeetCode #417. Pacific Atlantic Water Flow
 *
 */

class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        // Corner case
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Arrays.fill(pacific[0], true);
        // Arrays.fill(atlantic[m - 1], true);

        // the top and bottom line
        for (int i = 0; i < n; i++) {
             dfs(matrix, 0, i, 0, pacific);
             dfs(matrix, m - 1, i, 0, atlantic);
        }

        // the left and right line
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, 0, pacific);
            dfs(matrix, i, n - 1, 0, atlantic);
        }

        // get the same islands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;

    }

    private void dfs(int[][] matrix, int i, int j, int preHeight, boolean[][] ocean) {
       // base case
       if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1 || matrix[i][j] < preHeight || ocean[i][j]) return;
        ocean[i][j] = true;
        dfs(matrix, i + 1, j, matrix[i][j], ocean);
        dfs(matrix, i - 1, j, matrix[i][j], ocean);
        dfs(matrix, i, j + 1, matrix[i][j], ocean);
        dfs(matrix, i, j - 1, matrix[i][j], ocean);
    }
}
