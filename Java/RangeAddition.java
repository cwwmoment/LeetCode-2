/**
 * Created on 22 Dec 2018 by happygirlzt
 *
 * LeetCode #370. Range Addition
 *
 */

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        //Arrays.fill(res, 0);
        for (int[] update: updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            res[start] += inc;
            if (end < length - 1) res[end + 1] -= inc;
        }

        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}
