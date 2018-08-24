/**
 * LeetCode 200. Number of Islands
 * Created on 24/08/2018
 * @author happygirlzt
 *
 */
public class NumberOfIslands {
	/**
	 * DFS: 数有多少个岛屿，也就是有多少块连着的1
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		int res = 0;
		if (grid == null || grid.length == 0) return res;
		int rows = grid.length;
		int cols = grid[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] != '1') {
					continue;
				} else {
					dfs(grid, i, j);
					res++;
				}
			}
		}
		
		return res;
	}
	
	public void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length ||
				j >= grid[0].length || grid[i][j] != '1') return;
		// Visited is assigned to '2'
		grid[i][j] = '2';
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
		dfs(grid, i - 1, j);
	}
}
