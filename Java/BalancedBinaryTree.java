/*
 * LeetCode
 * happygirlzt
 * Created on 7 Aug 2018
 */

public class BalancedBinaryTree {
    public class TreeNode {
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
}
