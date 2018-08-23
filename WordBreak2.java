/**
 * LeetCode #140. Word Break II
 * 
 * @author happygirlzt
 *
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.lang.StringBuilder;

public class WordBreak2 {
	public static List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new LinkedList<>();
		
		boolean[][] dp = new boolean[s.length()+1][s.length()+1];
		dp[0][0] = true;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (wordDict.contains(s.substring(i, j+1))) {
					dp[i+1][j+1] = true;
				}
			}
		}
		
//		int left = 0, right = 0;
//		while (left <= right && right <= s.length()) {
//			if (wordDict.contains(s.substring(left, right))) {
//				sb.append(s.substring(left, right));
//				sb.append(" ");
//				left = right;
//			} else {
//				right ++;
//			}
//		}
		
		int left = 1, right = 1;
		while (left <= right && right <= s.length()) {
			if (dp[left][right] == true) {
				sb.append(s.substring(left - 1, right));
				sb.append(" ");
				// System.out.println("Append " + s.substring(left -1, right));
				dp[left][right] = false;
				left = right + 1;
				// System.out.println(s.charAt(left));
				// continue;
			}
			
			if (left == 1 && right == s.length()) {
				break;
			}
			
			if (right == s.length()) {
				res.add(sb.toString());
				System.out.println(sb);
				sb.setLength(0);
				left = 1;
				right = 1;
			}
			
			right++;
		}
		
		
		return res;
	}
	
	public static void main(String[] args) {
		// String s = "catsanddog";
		String s = "pineapplepenapple";
		// String s = "hashappy";
		List<String> list = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
		// List<String> list = Arrays.asList("has", "happy");
		wordBreak(s, list);
	}
}
