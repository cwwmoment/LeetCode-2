/**
 * LeetCode #304. Range Sum Query 2D - Immutable
 * 
 * Created by happygirlzt on 9 Sep 2018 at 8:22:09 PM
 *
 */

public class RangeSumQuery2 {
	private static int[][] dp;

	static class NumMatrix {
		public NumMatrix(int[][] matrix) {
			if (matrix.length == 0 || matrix[0].length == 0) {
				dp = null;
			} else {
				int rowNum = matrix.length;
				int colNum = matrix[0].length;
				dp = new int[rowNum + 1][colNum + 1];
				for (int i = 0; i <= rowNum; i++) {
					dp[i][0] = 0;
				}

				for (int j = 0; j <= colNum; j++) {
					dp[0][j] = 0;
				}
				
				for (int i = 1; i <= rowNum; i++) {
					for (int j = 1; j <= colNum; j++) {
						dp[i][j] = dp[i][j - 1] + matrix[i - 1][j - 1];
					}
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (dp == null) return 0;
			int res = 0;
			for (int i = row1; i <= row2; i++) {
				int tmp = dp[i + 1][col2 + 1] - dp[i + 1][col1];
				res += tmp;
			}

			return res;
		}
	}
	
	public static void main(String[] args) {
		int[][] nums = {{1}, {-7}};
		
		NumMatrix obj = new NumMatrix(nums);
		int param_1 = obj.sumRegion(0,0,0,0);
		System.out.println(param_1);
	}
}
