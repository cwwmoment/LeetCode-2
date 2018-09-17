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

    // Other's concise dfs
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }
}
