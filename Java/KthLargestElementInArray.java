/*
 * LeetCode #215. Kth Largest Element in an Array
 * happygirlzt
 * Created on 14 Aug
 */
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        Arrays.sort(nums);

        int len = nums.length;
        if (len < k) return -1;

        return nums[len - k];
    }

    // Solution 2: Priority Queue
    public static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.offer(i);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    // Solution 3: Divide and Conquer
    public int findKthLargest2(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;

        while(true) {

            while(i < hi && (a[++i] < a[lo]));
            while(j > lo && (a[lo] < a[--j]));

            if(i >= j) {
                break;
            }

            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // quickSort method
    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return -1;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];

        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot)
                left++;
            while (left <= right && nums[right] < pivot)
                right--;
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (start + k - 1 <= right)
            return quickSelect(nums, start, right, k);
        if (start + k - 1 >= left)
            return quickSelect(nums, left, end, k - (left - start));
        return nums[right + 1];
    }

    // Updated on 24 Jan 2019
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int order = nums.length - k;
            int pivotIndex = quickSelect(nums, 0, nums.length - 1, order);
            return nums[pivotIndex];
        }

        private int quickSelect(int[] a, int lo, int hi, int k) {
            // System.out.println("lo: " + lo + " hi: " + hi);
            if (lo == hi) return lo;


            int pivotIndex = partition(a, lo, hi);

            if (pivotIndex == k) {
                return pivotIndex;
            } else if (pivotIndex > k) {
                return quickSelect(a, lo, pivotIndex - 1, k);
            } else {
                return quickSelect(a, pivotIndex + 1, hi, k);
            }
        }

        private int partition(int[] a, int lo, int hi) {
            Random r = new Random();
            int pivotIndex = lo + r.nextInt(hi - lo);
            // System.out.println("pivotIndex " + pivotIndex);
            int pivot = a[pivotIndex];

            swap(a, pivotIndex, hi);
            int pos = hi;
            hi--;
            while (lo <= hi) {
                if (a[lo] > pivot) {
                    swap(a, lo, hi--);
                } else {
                    lo++;
                }
            }

            swap(a, lo, pos);
            return lo;
        }

        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
