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
}
