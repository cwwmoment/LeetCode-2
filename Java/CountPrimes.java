/*
 * LeetCode #204. Count Primes
 * happygirlzt
 * Created on 29 July 2018
 */
public class CountPrimes {

	// TLE
	public static int countPrimes1(int n) {
		int res = 0;
		if (n == 2)
			return 0;

		for (int j = 2; j < n; j++) {
			if (isPrime(j) == true) {
				res++;
			}
		}

		return res;
	}

	public static boolean isPrime(int t) {
		if (t == 2)
			return true;

		for (int i = 2; i <= t / 2; i++) {
			if (t % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static int countPrimes(int n) {
		if (n == 1 || n == 2)
			return 0;
		if (n == 3)
			return 1;
		
		boolean[] res = new boolean[n + 1];

		int count = 0;

		for (int i = 0; i < n + 1; i++) {
			res[i] = true;
		}

		for (int j = 2; j * j <= n + 1; j++) {
			if (res[j] == true) {
			for (int z = j * 2; z <= n; z += j) {
					res[z] = false;
				}
			}
		}

		for (int k = 2; k < n; k++) {
			if (res[k] == true) count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(4));
	}
}
