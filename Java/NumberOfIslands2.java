/**
  * Created on 7 Dec 2018 by happygirlzt
  *
  * LeetCode #305. Number of Islands II
  */

class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] pos) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        int[] roots = new int[m * n];
        
        Arrays.fill(roots, -1);
        int count = 0;
        
        for (int[] p : pos) {
            int root = p[0] * n + p[1];
            roots[root] = root;
            count++;
            
            for (int[] dir : dirs) {
                int r = dir[0] + p[0], c = dir[1] + p[1];
                int nb = r * n + c;
                if (r > m - 1 || r < 0 ||
                   c > n - 1 || c < 0 || roots[nb] == -1) continue;
                
                int rootNb = find(roots, nb);
                
                if (root != rootNb) {
                    roots[root] = rootNb;
                    root = rootNb;
                    
                    count--;
                }
            }
            
            res.add(count);
        }
        
        return res;
    }
    
    public int find(int[] roots, int i) {
        if (roots[i] != i) {
            roots[i] = find(roots, roots[i]);
        }
        
        return roots[i];
    }

    // Updated on 14 Feb 2019
    class DSU {
        int[] size;
        int[] parent;
        int count;
        
        public DSU(int N) {
            size = new int[N];
            parent = new int[N];
            
            for (int i = 0; i < N; i++) {
                size[i] = 1;
                parent[i] = -1;
            }
            count = 0;
        }
        
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }
        
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            if (size[i] < size[j]) {
                parent[i] = j;
                size[j] += size[i];
            } else {
                parent[j] = i;
                size[i] += size[j];
            }
            count--;
        }
        
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
    
    public List<Integer> numIslands3(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int N = m * n;
        DSU dsu = new DSU(N);
        
        int[] r = {1, -1, 0, 0};
        int[] c = {0, 0, 1, -1};
        
        for (int[] i : positions) {
            int x = i[0];
            int y = i[1];
            dsu.count++;
            
            int a = x * n + y;
            dsu.parent[a] = a;
            for (int j = 0; j < 4; j++) {
                int rr = x + r[j];
                int cc = y + c[j];
                int b = rr * n + cc;
                
                if (rr < 0 || cc < 0 || rr >= m || cc >= n || dsu.parent[b] == -1) continue;
                dsu.union(a, b);
            }
            
            res.add(dsu.count);
        }
        
        return res;
    }
}
