/**
 * Created on 9 Feb 2019 by happygirlzt
 *
 * LeetCode #721. Accounts Merge
 *
 */

 import java.util.*;

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
                // Do not forget to add two-ways
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

    // Updated on 14 Feb 2019
    // Union-find
    class DSU {
        int[] size;
        int[] parent;
        
        public DSU(int N) {
            size = new int[N];
            parent = new int[N];
            
            Arrays.fill(size, 1);
            // Arrays.fill(parent, -1);
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
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
        }
    }
    
    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
        DSU dsu = new DSU(10001);
        
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                
                emailToName.put(email, name);
                emailToId.putIfAbsent(email, id++);
                dsu.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }
        
        Map<Integer, List<String>> res = new HashMap<>();
        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToId.get(email));
            res.putIfAbsent(index, new ArrayList<>());
            res.get(index).add(email);
        }
        
        for (List<String> list: res.values()) {
            Collections.sort(list);
            list.add(0, emailToName.get(list.get(0)));
        }
        
        return new ArrayList(res.values());
    }
}
