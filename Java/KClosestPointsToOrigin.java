/**
 * Created on 3 Feb 2019 by happygirlzt
 *
 * LeetCode #973. K Closest Points to Origin
 *
 */

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
                return b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1];
            });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[maxHeap.size()][2];
        int index = 0;
        while (maxHeap.size() > 0) {
            res[index++] = maxHeap.poll();
        }

        return res;
    }
}
