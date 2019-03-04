/**
 * Created on 29 Dec 2018 by happygirlzt
 *
 * LeetCode #285. Inorder Successor in BST
 *
 */

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    // Updated on 3 Mar 2019
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            return findMin(p.right);
        }

        TreeNode succ = null;
        while (root != null) {
            if (root.val > p.val) {
                succ = root;
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else break;
        }

        return succ;
    }

    private TreeNode findMin(TreeNode p) {
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
}
