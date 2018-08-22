
/**
 * LeetCode #54 Spiral Matrix
 * @author happygirlzt
 * Date: August 21, 2018
 * Topics: Array
 */
import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
	/**
	 * 题意：给定一个二维矩阵matrix，返回螺旋该矩阵的值
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) return null;
		
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		
		while (true) {
			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
			top++;
			if (left > right || top > bottom) break;
			
			for (int j = top; j <= bottom; j++) {
				res.add(matrix[j][right]);
			}
			right--;
			if (top > bottom || left > right) break;
			
			for (int k = right; k >= left; k--) {
				res.add(matrix[bottom][k]);
			}
			bottom--;
			if (bottom < top || left > right) break;
			
			for (int g = bottom; g >= top; g--) {
				res.add(matrix[g][left]);
			}
			left++;
			if (left > right || bottom < top) break;
		}
		
		return res;
	}
}
