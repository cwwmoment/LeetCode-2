/**
 * Created on 7 Feb 2019 by happygirlzt
 *
 * LeetCode #446. Arithmetic Slices II - Subsequence
 *
 */

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        long res = 0;
        Map<Integer, Integer>[] map = new Map[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long delta = (long) A[i] - (long) A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }

                int diff = (int) delta;
                int sum = map[j].getOrDefault(diff, 0);
                int origin = map[i].getOrDefault(diff, 0);
                map[i].put(diff, origin + sum + 1);
                res += sum;
            }
        }

        return (int) res;
    }
}
