/**
 * Created on 25 Jan 2019 by happygirlzt
 *
 * LeetCode #314. Binary Tree Vertical Order Traversal
 *
 */

class Solution {
    class Node {
        TreeNode root;
        int hd;
        public Node(TreeNode root, int hd) {
            this.root = root;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            map.putIfAbsent(cur.hd, new ArrayList<>());
            map.get(cur.hd).add(cur.root.val);

            if (cur.root.left != null) {
                q.offer(new Node(cur.root.left, cur.hd - 1));
            }

            if (cur.root.right != null) {
                q.offer(new Node(cur.root.right, cur.hd + 1));
            }
        }

        for (List<Integer> value : map.values()) {
            res.add(value);
        }

        return res;
    }

    // Updated on 31 Jan 2019
    class Node {
        TreeNode root;
        int hd;
        public Node(TreeNode root, int hd) {
            this.root = root;
            this.hd = hd;
        }
    }

    private int minHd = 0, maxHd = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            map.putIfAbsent(cur.hd, new ArrayList());
            map.get(cur.hd).add(cur.root.val);
            minHd = Math.min(minHd, cur.hd);
            maxHd = Math.max(maxHd, cur.hd);
            if (cur.root.left != null) {
                q.offer(new Node(cur.root.left, cur.hd - 1));
            }

            if (cur.root.right != null) {
                q.offer(new Node(cur.root.right, cur.hd + 1));
            }
        }

        for (int i = minHd; i <= maxHd; i++) {
            res.add(map.get(i));
        }

        return res;
    }
}
