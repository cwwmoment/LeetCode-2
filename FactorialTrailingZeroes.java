/**
 * Created on 4 Oct 2018 by happygirlzt
 *
 * LeetCode #172. Factorial Trailing Zeroes
 */

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }

        int t = dp[n];

        System.out.println(t);
        int res = 0;
        while (t / 10 != 0) {
            if (t % 10 == 0) {
                res++;
            } else {
                break;
            }
            t = t / 10;
        }

        return res;
    }

    public int trailingZeroes1(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    // 上述思路写成迭代法
    public int trailingZeroes2(int n) {
        int count = n / 5;
        int i = 5;
        int f = count;
        while (f >= 5) {
            f /= 5;
            count += f;
        }

        return count;
    }
}
