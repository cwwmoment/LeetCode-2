/**
 * LeetCode 50. Pow(x, n)
 *
 * @author happygirlzt
 *
 */

public class PowXN {
    public double myPow(double x, int n) {
        // if (n <= Integer.MIN_VALUE || n >= Integer.MAX_VALUE) return 0.0;

        if (n == 0)
            return 1;
        if (x == 0)
            return 0;
        if (n < 0) {
            // Avoid overflow
            return (1 / x * myPow(1 / x, -(n + 1)));
        } else {
            return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        }
    }

    // Updated on 3 Feb 2019
    public double myPow1(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double res = 1;
        double curProduct = x;

        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res = res * curProduct;
            }

            curProduct = curProduct * curProduct;
        }
        return res;
    }
}
