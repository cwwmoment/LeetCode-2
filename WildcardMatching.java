import java.util.Arrays;

/**
 * LeetCode 44. Wildcard Matching
 * 
 * @author happygirlzt Created on 20 Aug 2018
 */
public class WildcardMatching {
	// Solution 0: Dynamic Programming
	public boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();

		if (m == 0)
			return n == 0;

		boolean[][] dp = new boolean[n + 1][m + 1];

		// initalize
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], false);
		}
		// empty s matches empty p
		dp[0][0] = true;

		// use '*' match empty string
		for (int j = 1; j < m + 1; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		// fill the table
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
	}

	// Solution 1: Two Pointers
	public static boolean isMatch1(String s, String p) {
		if (s == null || p == null) return false;
		
		int sp = 0, pp = 0;
		int match = -1, star = -1;

		while (sp < s.length()) {
			if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
				pp++;
				sp++;
			} else if (pp < p.length() && p.charAt(pp) == '*') {
				star = pp;
				match = sp;
				pp++;
			} else if (star != -1) {
				pp = star + 1;
				match++;
				sp = match;
			} else {
				return false;
			}
		}

		while (pp < p.length() && p.charAt(pp) == '*')
			pp++;

		return pp == p.length();
	}
	
	public static void main(String[] args) {
		String s = "aa";
		String p = "a";
		System.out.println(isMatch1(s, p));
	}
}
