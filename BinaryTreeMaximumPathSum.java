/**
 * Created on 9 Oct 2018 by happygirlzt
 *
 * LeetCode #124. Binary Tree Maximum Path Sum
 */

public class BinaryTreeMaximumPathSum {
    // 我的wrong answer做法
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return root.val;
        } else if (root.val >= 0) {
            if (maxPathSum(root.left) < 0 && maxPathSum(root.right) < 0) {
                return root.val;
            } else if (maxPathSum(root.left) < 0) {
                return maxPathSum(root.right) + root.val;
            } else if (maxPathSum(root.right) < 0) {
                return maxPathSum(root.left) + root.val;
            } else {
                return maxPathSum(root.left) + maxPathSum(root.right) + root.val;
            }
        } else if (root.left != null && root.right != null && root.val < 0) {
            return Math.max(maxPathSum(root.left), maxPathSum(root.right));
        } else if (root.left == null && root.val < 0) {
            return Math.max(maxPathSum(root.right), root.val);
        } else {
            return Math.max(maxPathSum(root.left), root.val);
        }
    }

    // Other's smart solution
    int max;

    public int maxPathSum1(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
