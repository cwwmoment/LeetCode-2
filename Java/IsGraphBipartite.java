/**
 * Created on 19 Jan 2019 by happygirlzt
 *
 * LeetCode #785. Is Graph Bipartite?
 *
 */

class Solution {
    // DFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }

        return true;
    }

    // BFS
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < nodes; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[cur];
                        q.offer(next);
                    } else if (colors[next] != -colors[cur]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
