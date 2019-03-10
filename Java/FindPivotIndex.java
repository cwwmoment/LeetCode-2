/**
 * Created on 7 Dec 2018 by happygirlzt
 *
 * LeetCode #724. Find Pivot Index
 *
 * */

class Solution {
    public int pivotIndex(int[] n) {
        if (n == null || n.length == 0) return -1;

        int rightSum = 0, leftSum = 0;
        for (int i : n) {
            rightSum += i;
        }

        for (int i = 0; i < n.length; i++) {
            rightSum -= n[i];
            if (leftSum == rightSum) return i;

            leftSum += n[i];
        }
        return -1;
    }
}
