/**
 * Created on 21 Mar 2019 by happygirlzt
 *
 * LeetCode #947. Most Stones Removed with Same Row or Column
 *
 */
class Solution {
    class DSU {
        private int[] size;
        private int[] root;
        private int count;

        public DSU(int N) {
            size = new int[N];
            root = new int[N];
            count = N;
            for (int i = 0; i < N; i++) {
                root[i] = i;
            }
        }

        private int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;

            if (size[rootX] <= size[rootY]) {
                root[rootX] = rootY;
                size[rootY]++;
            } else {
                root[rootY] = rootX;
                size[rootX]++;
            }
            count--;
        }
    }

    public int removeStones(int[][] stones) {
        int N = stones.length;
        DSU dsu = new DSU(N);

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }

        return N - dsu.count;
    }
}
