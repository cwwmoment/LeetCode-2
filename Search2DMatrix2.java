/**
 * LeetCode #240. Search a 2D Matrix II
 * 
 * Created by happygirlzt on 30 Aug 2018 at 9:17:45 PM
 *
 */

public class Search2DMatrix2 {
	// TODO: 还没想出来，先去跑步。。明天继续
	/**
	 * 这题一看题目就知道是二分搜索。。 先判断那几行不可能，然后在可能的那几行里再做二分搜索
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		// Corner case
		if (matrix == null)
			return false;
		
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		int top = 0, down = rowNum - 1;
		int left = 0, right = colNum - 1;

		// 找出有可能的几行
		for (int i = 0; i < rowNum; i++) {
			if (matrix[i][0] < target) {
				continue;
			} else if (matrix[i][0] == target) {
				return true;
			} else {
				down = i - 1;
				break;
			}
		}

		// 找出可能的几列
		for (int j = 0; j < colNum; j++) {
			if (matrix[0][j] < target) {
				continue;
			} else if (matrix[0][j] == target) {
				return true;
			} else {
				right = j - 1;
				break;
			}
		}

		
		System.out.println("top is = " + top + " Down is " + down);

	}
}
