/**
 * Created on 29 Sep 2018 by happygirlzt
 *
 * LeetCode #41. First Missing Positive
 */

public class FirstMissingPositive {
    // priority queue
    public int firstMissingPositive1(int[] nums) {
        if (nums.length == 0 || nums == null) return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
        }

        int res = 1;
        while (!pq.isEmpty() && pq.peek() <= 0) {
            pq.poll();
        }

        if (!pq.isEmpty()) {
            if (pq.peek() > 1) {
                return res;
            } else {
                int tmp = pq.poll();
                while (!pq.isEmpty() && pq.peek() <= (tmp + 1)) {
                    tmp = pq.poll();
                }

                return ++tmp;
            }
        } else {
            return res;
        }
    }

    // Updated on 24 Jan 2019
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return nums.length + 1;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
