/**
 * Created on 3 Dec 2018 by happygirlzt
 *
 * LeetCode #399. Evaluate Division
 *
 */
// The whole point is that you have to find this is a graph problem..!

public class EvaluateDivision {
    // Solution 1: Union-find
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, String> nodes = new HashMap<>();
        HashMap<String, Double> weights = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            union(values[i], equations[i][0], equations[i][1], nodes, weights);
        }

        double[] res = new double[queries.length];
        for (int j = 0; j < queries.length; j++) {
            String s1 = queries[j][0], s2 = queries[j][1];

            if (!nodes.containsKey(s1) ||
               !nodes.containsKey(s2) ||
               !find(s1, nodes, weights).equals(find(s2, nodes, weights))) {
                res[j] = -1.0;
            } else {
                res[j] = weights.get(s1) / weights.get(s2);
            }
        }

        return res;
    }

    public void union(double val, String s1, String s2, HashMap<String, String> nodes, HashMap<String, Double> weights) {
        if (!nodes.containsKey(s1)) {
            nodes.put(s1, s1);
            weights.put(s1, 1.0);
        }

        if (!nodes.containsKey(s2)) {
            nodes.put(s2, s2);
            weights.put(s2, 1.0);
        }

        String p1 = find(s1, nodes, weights);
        String p2 = find(s2, nodes, weights);
        nodes.put(p1, p2);
        weights.put(p1, val * weights.get(s2) / weights.get(s1));
    }

    public String find(String s, HashMap<String, String> nodes, HashMap<String, Double> weights) {
        if (s.equals(nodes.get(s))) {
            return s;
        }

        String father = nodes.get(s);
        String grandpa = find(father, nodes, weights);

        nodes.put(s, grandpa);
        weights.put(s, weights.get(s) * weights.get(father));

        return grandpa;
    }

    // Solution 2: BFS
    private class Path {
        String node;
        double val;

        public Path(String node, double val) {
            this.node = node;
            this.val = val;
        }
    }

    public double[] calcEquation1(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Path>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            double value = values[i];

            if (equation[0].equals(equation[1])) {
                continue;
            }

            if (!map.containsKey(equation[0])) {
                map.put(equation[0], new ArrayList<Path>());
            }

            if (!map.containsKey(equation[1])) {
                map.put(equation[1], new ArrayList<Path>());
            }

            map.get(equation[0]).add(new Path(equation[1], value));
            map.get(equation[1]).add(new Path(equation[0], 1.0 / value));
        }

        double[] res = new double[queries.length];
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < queries.length; i++) {
            String start = queries[i][0], end = queries[i][1];
            if (!map.containsKey(start) ||
                !map.containsKey(end)) {
                res[i] = -1;
            } else if (start.equals(end)) {
                res[i] = 1;
            } else {
                res[i] = bfs(map, start, end);
            }
        }

        return res;
    }

    private double bfs(Map<String, List<Path>> map, String start, String end) {
        Queue<Path> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new Path(start, 1));

        while (!q.isEmpty()) {
            Path p = q.poll();
            if (p.node.equals(end)) {
                return p.val;
            }
            visited.add(p.node);
            List<Path> paths = map.get(p.node);
            for (Path path: paths) {
                if (!visited.contains(path.node)) {
                    q.offer(new Path(path.node, p.val * path.val));
                }
            }
        }

        return -1;
    }

    // Updated on 20 Feb 2019 DFS
    public double[] calcEquation2(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> g = new HashMap<>();
        buildGraph(g, equations, values);
        
        double[] res = new double[queries.length];
        Arrays.fill(res, -1.0);
        int index = 0;
        for (String[] q : queries) {
            String a = q[0];
            String b = q[1];
            if (!g.containsKey(a) || !g.containsKey(b)) {
                index++;
                continue;
            }
            if (a.equals(b)) {
                res[index++] = 1.0;
            } else {
                dfs(g, a, b, new HashSet<>(), res, index, 1.0);
                index++;
            }
        }
        
        return res;
    }
    
    private void buildGraph(Map<String, Map<String, Double>> g, String[][] equations, double[] values) {
        for (int i = 0; i < values.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            g.putIfAbsent(a, new HashMap<>());
            g.putIfAbsent(b, new HashMap<>());
            g.get(a).put(b, values[i]);
            g.get(b).put(a, 1.0 / values[i]);
        }
    }
    
    private void dfs(Map<String, Map<String, Double>> g, String a, String b, Set<String> visited, double[] res, int index, double tmp) {
        visited.add(a);
        if (g.get(a) == null || g.get(a).size() == 0) return;
        if (g.get(a).containsKey(b)) {
            res[index] = g.get(a).get(b) * tmp;
            return;
        }
        
        for (String neigh: g.get(a).keySet()) {
            if (visited.contains(neigh)) continue;
            dfs(g, neigh, b, visited, res, index, tmp * g.get(a).get(neigh));
        }
    }
}
