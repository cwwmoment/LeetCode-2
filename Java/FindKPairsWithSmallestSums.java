/**
 * Created on 29 Mar 2019 by happygirlzt
 *
 * LeetCode #373. Find K Pairs with Smallest Sums
 *
 */

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                heap.offer(new Pair(nums1[i], nums2[j]));
             }
        }

        List<int[]> res = new ArrayList<>();
        if (n == 0) return res;
        for (int i = 0; i < k; i++) {
            if (heap.size() == 0) return res;
            int x = heap.peek().x;
            int y = heap.poll().y;
            res.add(new int[]{x, y});
        }

        return res;
    }

    class Pair implements Comparable<Pair> {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair otherPair) {
            int thisSum = x + y;
            int otherSum = otherPair.x + otherPair.y;
            if (thisSum < otherSum) {
                return -1;
            } else if (thisSum > otherSum) {
                return 1;
            } else return 0;
        }
    }
}
