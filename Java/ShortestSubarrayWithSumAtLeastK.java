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

    /* Updated on 25 Feb 2019
      注意点：
      0. 要存0，因为如果只有一个数，刚好大于或等于K，一般来说
      前缀和都要存0
      1. 只要保证队列里存的是上升的就可以了，不要队首的和大于0
      不要多此一举，每次check是否当前值减去队首的值合理就行了
      相当于，先得到一个有效区间，再得最小区间
      O(N), O(N)
      */
    public int shortestSubarray1(int[] A, int K) {
        int[] dp = new int[A.length + 1];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            dp[i + 1] = sum;
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
           // System.out.println(q);
            while (!q.isEmpty() && dp[q.peekLast()] > dp[i]) {
                q.pollLast();
            }
            
            /*
            while (!q.isEmpty() && dp[q.peekFirst()] < 0) {
                q.pollFirst();
            }
            */
            
            while (!q.isEmpty() && dp[i] - dp[q.peekFirst()] >= K) {
                min = Math.min(min, i - q.pollFirst());
            }
            
            q.offerLast(i);
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
