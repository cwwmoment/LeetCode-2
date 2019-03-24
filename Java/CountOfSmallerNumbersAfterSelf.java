/**
 * Created on 17 Feb 2019 by happygirlzt
 *
 * LeetCode #315. Count of Smaller Numbers After Self
 *
 */

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        mergeSort(nums, index, 0, nums.length - 1, count);
        for (int i : count) {
            res.add(i);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] index, int l, int r, int[] count) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
        mergeSort(nums, index, l , mid, count);
        mergeSort(nums, index, mid + 1, r, count);
        merge(nums, index, l, r, count);
    }

    private void merge(int[] nums, int[] index, int start, int end, int[] count) {
        int mid = (end - start) / 2 + start;
        int l = start, r = mid + 1;
        int i = 0, rightCounter = 0;
        int[] newIndex = new int[end - start + 1];
        while (l <= mid && r <= end) {
            if (nums[index[r]] < nums[index[l]]) {
                newIndex[i] = index[r];
                rightCounter++;
                r++;
            } else {
                newIndex[i] = index[l];
                count[index[l]] += rightCounter;
                l++;
            }
            i++;
        }

        while (l <= mid) {
            newIndex[i] = index[l];
            count[index[l]] += rightCounter;
            l++;
            i++;
        }

        while (r <= end) {
            newIndex[i] = index[r];
            r++;
            i++;
        }

        for (int j = start; j <= end; j++) {
            index[j] = newIndex[j - start];
        }
    }

    // Updated on 24 Mar 2019
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] count = new int[n];
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }

        mergeSort(items, 0, n - 1, count);
        for (int c: count) {
            res.add(c);
        }
        return res;
    }

    private void mergeSort(Item[] items, int lo, int hi, int[] count) {
        if (lo >= hi) return;
        int mid = (hi - lo) / 2 + lo;
        mergeSort(items, lo, mid, count);
        mergeSort(items, mid + 1, hi, count);
        merge(items, lo, hi, count);
    }

    private void merge(Item[] items, int lo, int hi, int[] count) {
        int mid = lo + (hi - lo) / 2;
        int loPtr = lo, hiPtr = mid + 1;
        int index = 0, rightCounter = 0;
        Item[] sorted = new Item[hi - lo + 1];
        while (loPtr <= mid && hiPtr <= hi) {
            if (items[hiPtr].val < items[loPtr].val) {
                sorted[index++] = items[hiPtr].val;
                hiPtr++;
                rightCounter++;
            } else {
                count[loPtr.index] += rightCounter;
                loPtr++;
            }
        }

        while (loPtr <= mid) {
            sorted[index++] = items[loPtr.val];
            count[loPtr.index] += rightCounter;
            loPtr++;
        }

        while (hiPtr <= hi) {
            sorted[index++] = items[hiPtr.val];
            hiPtr++;
        }
    }

    class Item {
        int val;
        int index;
        public Item(int v, int i) {
            val = v;
            index = i;
        }
    }
}
