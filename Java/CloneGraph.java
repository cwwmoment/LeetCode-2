/**
 * Created on 30 Jan 2019 by happygirlzt
 *
 * LeetCode #133. Clone Graph
 *
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        helper(map, node);
        return map.get(node);
    }

    private void helper(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (map.containsKey(node)) return;
        map.put(node, new UndirectedGraphNode(node.label));
        if (node.neighbors == null) return;
        for (UndirectedGraphNode neigh: node.neighbors) {
            helper(map, neigh);
            // Pay attention to here
            // should firstly get the cloned node, then add them
            map.get(node).neighbors.add(map.get(neigh));
        }
    }
}
