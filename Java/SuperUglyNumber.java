/**
 * Created on 27 Mar 2019 by happygirlzt
 *
 * LeetCode #313. Super Ugly Number
 *
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglyNum = new int[n + 1];
        Arrays.fill(uglyNum, Integer.MAX_VALUE);
        uglyNum[0] = 1;
        uglyNum[1] = primes[0];

        int[] pointer = new int[primes.length];
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < primes.length; j++) {
                // Bug: Overflow
                // uglyNum[i] = Math.min(primes[j] * uglyNum[i - 1], uglyNum[i]);
                for (int k = pointer[j]; k < i; k++) {
                    if (uglyNum[k] * primes[j] <= uglyNum[i - 1]) continue;
                    uglyNum[i] = Math.min(uglyNum[k] * primes[j], uglyNum[i]);
                    pointer[j] = k;
                    break;
                }
            }
        }

        return uglyNum[n - 1];
    }
}
