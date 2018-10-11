/**
 * Created on 11 Oct 2018 by happygirlzt
 *
 * LeetCode #646. Maximum Length of Pair Chain
 */

public class MaximumLengthOfPairChain {
    // 可怕，这题好简单啊，可是我相反了，然后导致没做出来，
    // 还想复杂了。。感觉最近算法能力又下降了（虽然本来也不怎么样
    // 还是熟能生巧，接下来要多做dp的题目
    // 我的错误做法
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;

        Arrays.sort(pairs, (a, b)->Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            System.out.println(pairs[i][0] + ", " + pairs[i][1]);
        }

        int n = pairs.length;
        int[][] dp = new int[n][n];

        // initialize
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        int res = 1;
        for (int i = 0; i < n; i++) {
            int front = pairs[i][1];
            for (int j = i + 1; j < n; j++) {
                if (pairs[j][0] > front) {
                    dp[i][j] = dp[i][j - 1] + 1;
                    front = dp[j][1];
                    System.out.println(dp[j][0]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }

                if (j == n - 1) {
                    res = Math.max(dp[i][j], res);
                }
            }
        }

        return res;
    }

    // 别人的做法
    public int findLongestChain1(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;

        Arrays.sort(pairs, (a, b)->Integer.compare(a[0], b[0]));

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
            }
        }

        return dp[pairs.length - 1];
    }
}
