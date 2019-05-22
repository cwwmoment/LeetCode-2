/**
 * Created on 22 May 2019 by happygirlzt
 *
 * LeetCode #1046. Last Stone Weight
 *
 */

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int s : stones) {
            heap.offer(s);
        }

        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            if (x == y) continue;
            heap.offer(x - y);
        }

        return heap.size() == 0 ? 0 : heap.peek();
    }
}
