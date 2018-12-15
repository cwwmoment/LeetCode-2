/**
 * Created on 15 Dec 2018 by happygirlzt
 *
 * LeetCode #841. Keys and Rooms
 *
 */

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;

        // Dijkstra's do not have to the shortest
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < rooms.size(); i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            for (int j : rooms.get(i)) {
                graph.get(i).add(j);
            }
        }

        Queue<Integer> q = new LinkedList<>();   // haven't visited
        Set<Integer> visited = new HashSet<>();    // visited
        q.offer(0);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visited.contains(cur)) continue;
            visited.add(cur);

            if (graph.containsKey(cur)) {
                for (int destNode: graph.get(cur)) {
                    q.add(destNode);
                }
            }
        }

        return visited.size() == rooms.size() ? true : false;
    }

    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;
        boolean[] visited = new boolean[rooms.size()];

        dfs(visited, rooms, 0);

        for (boolean v: visited) {
            if (!v) return false;
        }

        return true;
    }

    private void dfs(boolean[] visited, List<List<Integer>> rooms, int room) {
        if (visited[room]) return;

        visited[room] = true;
        for (int neighbor: rooms.get(room)) {
            dfs(visited, rooms, neighbor);
        }
    }
}
