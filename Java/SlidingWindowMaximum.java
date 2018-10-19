/**
 * Created on 3 Oct 2018 by happygirlzt
 *
 * LeetCode #239. Sliding Window Maximum
 */

import java.util.Queue;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    // 超时的做法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;

        Queue<Integer> q = new LinkedList<>();

        int len = nums.length - k + 1;
        int[] res = new int[len];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int j = 0; j < k; j++) {
            q.offer(nums[j]);
            pq.offer(nums[j]);
        }

        res[0] = pq.poll();

        for (int i = 1; i < len; i++) {
            q.poll();
            q.offer(nums[i + k - 1]);

            PriorityQueue<Integer> pq1 = new PriorityQueue<>(q);

            for (int j = 0; j < k - 1; j++) {
                pq1.poll();
            }
            res[i] = pq1.poll();
        }

        return res;
    }

    // Other's smart solution
    // Deque 双向队列

    public int[] maxSlidingWindow1(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }

        int n = a.length;
        int[] win = new int[n - k + 1];
        int r = 0;

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            // remove smaller numbers in k range
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                win[r++] = a[q.peek()];
            }
        }

        return win;
    }
}
