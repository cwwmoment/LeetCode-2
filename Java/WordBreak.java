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

    // Solution 1: BFS
    // Updated on 16 Jan 2019
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str: wordDict) {
            set.add(str);
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] visited = new boolean[s.length() + 1];
        visited[0] = true;

        while (!q.isEmpty()) {
            int start = q.poll();
            for (int end = start + 1; end <= s.length(); end++) {
                if (!visited[end] && set.contains(s.substring(start, end))) {
                    q.offer(end);
                    if (end == s.length()) return true;
                    visited[end] = true;
                }
            }
        }

        return false;
    }
}
