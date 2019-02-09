/**
 * Created on 9 Feb 2019 by happygirlzt
 *
 * LeetCode #721. Accounts Merge
 *
 */

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> name = new HashMap<>();
        buildGraph(graph, name, accounts);

        Set<String> visited = new HashSet<>();
        for (String email : name.keySet()) {
            List<String> list = new ArrayList<>();
            if (visited.add(email)) {
                dfs(list, graph, email, visited);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }

        return res;
    }

    private void buildGraph(Map<String, Set<String>> graph, Map<String, String> name, List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                name.put(email, userName);
                if (i == 1) continue;
                String neigh = account.get(i - 1);
                graph.putIfAbsent(email, new HashSet<>());
                graph.putIfAbsent(neigh, new HashSet<>());
                graph.get(email).add(neigh);
                graph.get(neigh).add(email);
            }
        }
    }

    private void dfs(List<String> list, Map<String, Set<String>> graph, String email, Set<String> visited) {
        list.add(email);
        if (graph.get(email) == null) return;
        for (String neigh: graph.get(email)) {
            if (visited.add(neigh)) {
                dfs(list, graph, neigh, visited);
            }
        }
    }
}
