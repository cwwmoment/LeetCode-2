/**
 * Created on 24 Mar 2019 by happygirlzt
 *
 * LeetCode #1020. Partition Array Into Three Parts With Equal Sum
 *
 */

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }

        if (sum % 3 != 0) return false;
        int subSum = sum / 3;
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            preSum += A[i];
            if (preSum == subSum) {
                preSum = 0;
                count++;
            }
        }

        return count == 3;
    }
}
