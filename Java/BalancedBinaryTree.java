/*
 * LeetCode
 * happygirlzt
 * Created on 7 Aug 2018
 */

public class BalancedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return - 1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    // Updated on 3 Mar 2019
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        helper(root);
        return balanced;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) balanced = false;
        return Math.max(left, right) + 1;
    }
}
