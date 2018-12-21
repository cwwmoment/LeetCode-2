/**
 * Created on 21 Dec 2018 by happygirlzt
 *
 * LeetCode #694. Number of Distinct Islands
 *
 */

class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 'o');
                    // grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        // System.out.println(set);
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, char dir) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) return;
        // visited.add(new StringBuilder(i + j));
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i + 1, j, sb, 'l');
        dfs(grid, i - 1, j, sb, 'r');
        dfs(grid, i, j + 1, sb, 'u');
        dfs(grid, i, j - 1, sb, 'd');
        sb.append('b');
    }

}
