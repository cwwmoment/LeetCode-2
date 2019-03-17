/**
 * Created on 17 Mar 2019 by happygirlzt
 *
 * LeetCode #778. Swim in Rising Water
 *
 */

class Solution {
    private static final int[] dr = {1, -1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((k1, k2) -> grid[k1 / n][k1 % n] - grid[k2 / n][k2 % n]);
        heap.offer(0);
        int res = 0;
        while (!heap.isEmpty()) {
            int k = heap.poll();
            int r = k / n, c = k % n;
            res = Math.max(res, grid[r][c]);
            if (r == n - 1 && c == n - 1) return res;

            for (int i = 0; i < 4; i++) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * n + cc;
                if (0 <= cr && cr < n && 0 <= cc && cc < n &&
                    !seen.contains(ck)) {
                    heap.offer(ck);
                    seen.add(ck);
                }
            }
        }

        return -1;
    }
}
