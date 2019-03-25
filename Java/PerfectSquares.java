/**
 * LeetCode #279. Perfect Squares
 *
 * Created on 13 Sep 2018 by happygirlzt
 */

/*
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * This problem is like the combination of coin change and valid perfect squares
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PerfectSquares {
    public static int numSquares(int n) {
        List<Integer> sqs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (isSquare(i)) {
                sqs.add(i);
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (Integer s : sqs) {
            for (int j = s; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - s] + 1);
            }
        }

        return dp[n] == Integer.MAX_VALUE - 1 ? n : dp[n];
    }

    public static boolean isSquare(int num) {
        int left = 0, right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == num || left * left == num || right * right == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else if (mid * mid < num) {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    // BFS: Updated on 9 Feb 2019
    public int numSquares1(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                for (int j = 1; j * j <= n; j++) {
                    int v = u + j * j;
                    if (v == n) return depth;
                    if (v > n) break;
                    if (!visited.contains(v)) {
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
        }

        return depth;
    }

    // Updated on 25 Mar 2019
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i - j * j >= 0)
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}
