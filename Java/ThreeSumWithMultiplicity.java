/**
 * Created on 18 Apr 2019 by happygirlzt
 *
 * LeetCode #923. 3Sum With Multiplicity
 *
 */

class Solution {
    // 3 pointers
    public int threeSumMulti(int[] A, int target) {
        int mod = 1_000_000_007;

        Arrays.sort(A);
        long res = 0;
        for (int i = 0; i < A.length; i++) {
            int twoSum = target - A[i];
            int lo = i + 1, hi = A.length - 1;
            while (lo < hi) {
                if (A[lo] + A[hi] == twoSum) {
                    if (A[lo] != A[hi]) {
                        int left = 1, right = 1;

                        while (lo + 1 < hi && A[lo] == A[lo + 1]) {
                            lo++;
                            left++;
                        }

                        while (hi - 1 > lo && A[hi] == A[hi - 1]) {
                            hi--;
                            right++;
                        }
                        res += left * right;
                        res %= mod;
                        lo++; hi--;
                    } else {
                        res += (hi - lo + 1) * (hi - lo) / 2;
                        res %= mod;
                        break;
                    }

                } else if (A[lo] + A[hi] < twoSum) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return (int) res;
    }
}
