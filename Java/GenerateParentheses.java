/*
 * LeetCode # 22. Generate Parentheses
 * happygirlzt
 * Created on 2018-7-25 
 * Backtracking
 */
import java.util.List;		
import java.util.ArrayList;
import java.lang.StringBuilder;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		
		if (n < 0) return res;
		StringBuilder sb = new StringBuilder();
		
		helper(n, sb, res, 0, 0);		
		return res;
	}
	
	public void helper(int n, StringBuilder sb, List<String> result, int l, int r) {
		// base case
		if (l == r && l == n) {
			result.add(sb.toString());
			return;
		}
		
		if (l < r || l > n) {
			return;
		}
		
		// left
		if (l < n) {
			helper(n, sb.append("("), result, l + 1, r);
			sb.setLength(sb.length() - 1);
		}
		
		// right
		if (r < l) {
			helper(n, sb.append(")"), result, l, r + 1);
			sb.setLength(sb.length() - 1);
		}
	}
}
	
