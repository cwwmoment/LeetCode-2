/**
 * Created on on 2018, updated on 24 Feb 2019
 * 
 * LeetCode #10. Regular Expression Matching
 */

/*
 * dp[i][j] = string s with len i matches string p with len j
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		
		for (int i = 1; i <= p.length(); i++) {
			if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
				dp[0][i] = true;
			}
		}
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
						dp[i][j] = dp[i][j - 2];
					} else {
						dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
					}
				}
			}
		}
		
		return dp[s.length()][p.length()];
	}

	// Updated on 24 Feb 2019
	public boolean isMatch1(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        
        for (int i = 2; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }  else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) || 
                              p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[sLen][pLen];
    }
}
