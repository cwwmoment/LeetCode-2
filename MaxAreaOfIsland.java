/**
 * LeetCode #695. Max Area of Island
 * 
 * Created by happygirlzt on 5 Sep 2018 at 10:44:24 PM
 *
 */
public class MaxAreaOfIsland {
	// DFS
	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 0) {
					maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
				}
			}
		}
		
		return maxArea;
	}
	
	public int areaOfIsland(int[][] grid, int i, int j) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0) {
			grid[i][j] = 0;
			return 1 + areaOfIsland(grid, i + 1, j) + areaOfIsland(grid, i - 1, j) +
					areaOfIsland(grid, i, j + 1) + areaOfIsland(grid, i, j - 1);
		}
		
		return 0;
	}
}
