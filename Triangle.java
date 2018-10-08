/**
 * Created on 4 Oct 2018 by happygirlzt
 *
 * LeetCode #120. Triangle
 */

public class Triangle {
    // 错误写法，贪心算法不对 bottom-up
    public int minimumTotal(List<List<Integer>> tri) {
        int len = tri.size();
        if (len == 0 || tri == null) return 0;

        int res = 0;
        int[] dp = new int[len + 1];

        dp[0] = 0;
        dp[1] = tri.get(0).get(0);

        int k = 0;
        for (int i = 1; i < len; i++) {
            int s1 = tri.get(i).get(k) + dp[i];
            int s2 = tri.get(i).get(k + 1) + dp[i];

            if (s1 <= s2) {
                dp[i + 1] = s1;
            } else {
                k++;
                dp[i + 1] = s2;
            }
        }

        return dp[len];
    }

    public int minimumTotal1(List<List<Integer>> tri) {
        int len = tri.size();
        if (len == 0 || tri == null) return 0;

        int res = 0;
        int[] dp = new int[len + 1];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + tri.get(i).get(j);
            }
        }

        return dp[0];
    }

    // 上述解法的优化版
    public int minimumTotal2(List<List<Integer>> tri) {
        for (int i = tri.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int self = tri.get(i).get(j);
                int res = Math.min(tri.get(i + 1).get(j) + self,
                                   tri.get(i + 1).get(j + 1) + self);
                tri.get(i).set(j, res);
            }
        }

        return tri.get(0).get(0);
    }
}
