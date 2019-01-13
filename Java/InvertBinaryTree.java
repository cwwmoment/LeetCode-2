/**
 * Created on 17 Sep 2018 by happygirlzt
 *
 * LeetCode #226. Invert Binary Tree
 */
public class InvertBinaryTree {
    public TreeNode invertTree1(TreeNode root) {
        // My naive solution
        if (root == null) return root;

        helper(root);

        return root;
    }

    public void helper(TreeNode root) {
        if (root.left != null && root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        } else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        } else if (root.right != null && root.left == null) {
            root.left = root.right;
            root.right = null;
        }

        if (root.left != null) {
            invertTree(root.left);
        }

        if (root.right != null) {
            invertTree(root.right);
        }
    }

    // Updated on 13 Jan 2019
    // dfs
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    // bfs
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;

            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }

        return root;
    }
}
