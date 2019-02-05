/**
 * Created on 5 Feb 2019 by happygirlzt
 *
 * LeetCode #862. Shortest Subarray with Sum at Least K
 *
 */

class Solution {
    /* 用双向队列，存储升序的前缀和
     * 以获得有效的区间，然后试图找最小的有效区间
     */
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }

        Deque<Integer> q = new ArrayDeque<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            while (!q.isEmpty() && preSum[i] <= preSum[q.getLast()]) {
                q.pollLast();
            }

            while (!q.isEmpty() && preSum[i] >= preSum[q.getFirst()] + K) {
                res = Math.min(res, i - q.removeFirst());
            }

            q.addLast(i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
