/**
 * Created on 15 Dec 2018 by happygirlzt
 *
 * LeetCode #743. Network Delay Time
 *
 */

class Solution {
    // Dijkstrs's algorithm
    public int networkDelayTime(int[][] times, int N, int K) {
        // use a HashMap to save the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge: times) {
            graph.putIfAbsent(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((h1, h2) -> h1[0] - h2[0]);  // save the delay at index 0, the destination at index 1

        heap.offer(new int[]{0, K});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int delay = cur[0], sourceNode = cur[1];

            if (!dist.containsKey(sourceNode)) {
                dist.put(sourceNode, delay);
            } else {
                continue;
            }

            if (graph.containsKey(sourceNode)) {
                for (int[] path : graph.get(sourceNode)) {
                    if (!dist.containsKey(path[0])) {
                        heap.offer(new int[]{delay + path[1], path[0]});
                    }
                }
            }
        }

        if (dist.size() != N) return -1;
        int res = 0;
        for (int delay: dist.values()) {
            res = Math.max(delay, res);
        }

        return res;
    }

    // Bellman Ford's algorithm
    public int networkDelayTime1(int[][] times, int N, int K) {
        double[] disTo = new double[N];
        Arrays.fill(disTo, Double.POSITIVE_INFINITY);
        disTo[K - 1] = 0;

        for (int i = 1; i < N; i++) {
            for (int[] edge : times) {
                int u = edge[0] - 1, v = edge[1] - 1, delay = edge[2];
                if (disTo[v] > disTo[u] + delay) {
                    disTo[v] = disTo[u] + delay;
                }
            }
        }

        double res = Double.NEGATIVE_INFINITY;
        for (double i : disTo) {
            res = Math.max(i, res);
        }

        return res == Double.POSITIVE_INFINITY ? -1 : (int) res;
    }
}
