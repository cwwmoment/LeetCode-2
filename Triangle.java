/**
 * Created on 4 Oct 2018 by happygirlzt
 *
 * LeetCode #120. Triangle
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> tri) {
        int len = tri.size();
        if (len == 0 || tri == null) return 0;

        int res = 0;
        int[] dp = new int[len + 1];

        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < tri.get(i).size(); j++) {
                dp[i + 1] = Math.min(tri.get(i).get(j) + tri.get(i - 1).get(j - 1),
                                     tri.get(i).get(j) + tri.get(i - 1).get(j));

                //                dp[i + 1] = Math.min(dp[i + 1], tmp);
            }
        }

        return dp[len];
    }
}
