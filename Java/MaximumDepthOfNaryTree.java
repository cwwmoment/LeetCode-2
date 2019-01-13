/**
 * LeetCode #559. Maximum Depth of N-ary Tree
 *
 * Created on 2018-08-28
 *
 * @author happygirlzt
 *
 */

public class MaximumDepthOfNaryTree {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {};
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int max = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;

        helper(root, 1);
        return max;
    }

    public void helper(Node root,int depth) {
        if (root == null) return;
        max = Math.max(max, depth);

        for (Node node : root.children) {
            helper(node, depth + 1);
        }
    }

    // Written on 13 Jan 2019
    // dfs
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;
        int max = Integer.MIN_VALUE;

        for (Node child: root.children) {
            max = Math.max(max, maxDepth(child) + 1);
        }

        return max;
    }

    // bfs
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.children == null || cur.children.size() == 0) continue;
                for (Node child : cur.children) {
                    q.offer(child);
                }
            }
            level++;
        }

        return level;
    }
}
