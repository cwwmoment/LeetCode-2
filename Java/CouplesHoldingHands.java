/**
 * Created on 22 Mar 2019 by happygirlzt
 *
 * LeetCode #765. Couples Holding Hands
 *
 */

class Solution {
    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        DSU dsu = new DSU(N);
        for (int i = 0; i < N; i++) {
            int x = row[i * 2];
            int y = row[i * 2 + 1];
            dsu.union(x / 2, y / 2);
        }

        return N - dsu.count;
    }
}

class DSU {
    public int count;
    private int[] size;
    private int[] root;

    public DSU(int N) {
        this.count = N;
        size = new int[N];
        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    public void union(int x, int y) {
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
