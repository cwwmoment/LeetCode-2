/**
 * Created on 30 Jan 2019 by happygirlzt
 *
 * LeetCode #133. Clone Graph
 *
 */

public class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    private void dfs(Node node, Map<Node, Node> map) {
        if (node == null) return;
        if (map.containsKey(node)) return;
        Node dup = new Node(node.val, new ArrayList<>());
        map.put(node, dup);
        for (Node neigh: node.neighbors) {
            dfs(neigh, map);
            map.get(node).neighbors.add(map.get(neigh));
        }
    }

    // Updated on 6 Mar 2019
    // bfs
    public Node cloneGraph1(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        Node dup = new Node(node.val, new ArrayList<>());
        map.put(node, dup);
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node neigh: cur.neighbors) {
                if (!map.containsKey(neigh)) {
                    q.offer(neigh);
                    Node neighDup = new Node(neigh.val, new ArrayList<>());
                    map.put(neigh, neighDup);
                    map.get(cur).neighbors.add(neighDup);
                } else {
                    map.get(cur).neighbors.add(map.get(neigh));
                }
            }
        }

        return dup;
    }
}
