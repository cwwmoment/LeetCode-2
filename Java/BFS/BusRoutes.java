/**
 * Created on 7 Nov 2018 by happygirlzt
 *
 * LeetCode #815. Bus Routes
 *
 */

public class BusRoutes {
    private class Pair {
        int x; int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Solution 1: Use HashMap and HashSet do BFS.
    // Do not use ArrayList, as the add opeartion is O(n)
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        // put the visied stop into set
        HashSet<Integer> set = new HashSet<>();

        if (S == T) return 0;
        // put the bus stop and the routes it can reach to map
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                HashSet<Integer> route = map.getOrDefault(routes[i][j], new HashSet<>());
                route.add(i);
                map.put(routes[i][j], route);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(S, 0));
        set.add(S);

        while (!q.isEmpty()) {

            // for (int j = 0; j < len; j++) {
                Pair cur = q.poll();
                if (cur.x == T) return cur.y;

                HashSet<Integer> levels = map.get(cur.x);

                for (int level : levels) {
                    // if (set.contains(routes[cur.x][l])) continue;

                    for (int i = 0; i < routes[level].length; i++) {
                        if (!set.contains(routes[level][i])) {
                            set.add(routes[level][i]);
                            q.offer(new Pair(routes[level][i], cur.y + 1));
                        }
                    }
                }
        }
            return -1;

    }
}
