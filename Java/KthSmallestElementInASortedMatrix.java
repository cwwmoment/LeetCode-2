/**
 * Created on 29 Mar 2019 by happygirlzt
 *
 * LeetCode #378. Kth Smallest Element in a Sorted Matrix
 *
 */

class Solution {
    // Time: O(NE + klogN)
    // Space: O(N)
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0) return -1;
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Item> heap = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            heap.offer(new Item(matrix[i][0], i, 0));
        }
        int count = 0;
        int res = 0;
        while (count < k) {
            Item item = heap.poll();
            res = item.val;
            count++;
            int rowIndex = item.rowIndex;
            int colIndex = item.colIndex;

            if (colIndex != n - 1) {
                heap.offer(new Item(matrix[rowIndex][colIndex + 1], rowIndex, colIndex + 1));
            }
        }
        return res;
    }

    class Item implements Comparable<Item> {
        int val;
        int rowIndex, colIndex;
        public Item(int v, int i, int j) {
            val = v;
            rowIndex = i;
            colIndex = j;
        }

        public int compareTo(Item otherItem) {
            if (this.val < otherItem.val) return -1;
            if (this.val > otherItem.val) return 1;
            return 0;
        }
    }
}
