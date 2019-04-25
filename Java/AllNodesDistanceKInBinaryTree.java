/**
 * Created on 25 Apr 2019 by happygirlzt
 *
 * LeetCode #863. All Nodes Distance K in Binary Tree
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// use dfs to record the parent of each node
// use bfs to calculate the distance
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map);

        int dist = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(null);
        q.offer(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(null);
        visited.add(target);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                if (dist == K) {
                    List<Integer> res = new ArrayList<>();
                    for (TreeNode n : q) {
                        res.add(n.val);
                    }

                    return res;
                }

                q.offer(null);
                dist++;
            } else {
                if (visited.add(cur.left)) {
                    q.offer(cur.left);
                }

                if (visited.add(cur.right)) {
                    q.offer(cur.right);
                }

                if (visited.add(map.get(cur))) {
                    q.offer(map.get(cur));
                }
            }
        }

        return new ArrayList<>();
    }

    private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        map.put(root, parent);
        dfs(root.left, root, map);
        dfs(root.right, root, map);
    }
}
