/**
 * Created on 11 Jan 2019 by happygirlzt
 *
 * LeetCode #702. Search in a Sorted Array of Unknown Size
 *
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int lo = 0, hi = 10000;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (reader.get(mid) == Integer.MAX_VALUE) {
                hi = mid - 1;
            } else {
                if (reader.get(mid) > target) {
                    hi = mid - 1;
                } else if (reader.get(mid) == target) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }
}
