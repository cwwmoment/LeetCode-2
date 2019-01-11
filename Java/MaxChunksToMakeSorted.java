/**
 * Created on 11 Jan 2019 by happygirlzt
 *
 * LeetCode #769. Max Chunks To Make Sorted
 *
 */

// Do not ignore this important information
// Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions)

class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 0) return 0;
        int res = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) res++;
        }

        return res;
    }
}
