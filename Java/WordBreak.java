/**
 * LeetCode #139. Word Break
 * @author happygirlzt
 *
 */

public class WordBreak {
    // Solution 0: DP
    // 为什么我没有想到dp
    public static boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
