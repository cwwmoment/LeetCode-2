/**
 * Created on 15 Feb 2019 by happygirlzt
 * 
 * LeetCode #658. Find K Closest Elements
 * 
 * Binary Search, find the start index of the result
 */

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int lo = 0, hi = arr.length - k;
        // Alternative: hi = arr.length - k - 1

        while (lo < hi) {
            // Alternative: lo <= hi
            int mid = lo + (hi - lo) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                lo = mid + 1;
            } else {
                hi = mid;
                // Alternative: hi = mid - 1
            }
        }

        for (int i = 0; i < k; i++) {
            res.add(arr[i + lo]);
        }

        return res;
    }
}