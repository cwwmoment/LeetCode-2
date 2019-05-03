/**
 * Modified on 3 May 2019 by happygirlzt
 *
 * LeetCode #446. Arithmetic Slices II - Subsequence
 *
 */

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent((long) A[i], new ArrayList<>());
            map.get((long) A[i]).add(i);
        }

        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long target = 2 * (long) A[j] - A[i];
                if (map.containsKey(target)) {
                    for (int k : map.get(target)) {
                        if (k < j) {
                            dp[i][j] += (dp[j][k] + 1);
                        }
                    }
                }

                res += dp[i][j];
            }
        }

        return res;
    }
}
