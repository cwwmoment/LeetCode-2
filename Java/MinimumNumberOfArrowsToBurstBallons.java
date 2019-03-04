/**
 * Created on 4 Mar 2019 by happygirlzt
 *
 * LletCode #452. Minimum Number of Arrows to Burst Balloons
 *
 */

class Solution {
    // My solution, Time O(NlogN), Space O(k)
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 ) return 0;
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int[] candidate = new int[2];
        for (int[] p : points) {
            if (p.length == 0) continue;
            if (maxHeap.isEmpty() || maxHeap.peek() < p[0] ||
                p[0] > candidate[1] || p[0] < candidate[0]) {
                maxHeap.offer(p[1]);
                candidate[0] = p[0];
                candidate[1] = p[1];
            } else {
                candidate[0] = Math.max(candidate[0], p[0]);
                candidate[1] = Math.min(maxHeap.peek(), p[1]);
                maxHeap.offer(Math.min(p[1], maxHeap.poll()));
            }
        }

        return maxHeap.size();
    }

    // Other's solution
    public int findMinArrowShots1(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        int threshold = points[0][1];
        int res = 1;

        for (int[] p : points) {
            if (p[0] > threshold) {
                res++;
                threshold = p[1];
            }
        }

        return res;
    }
}
