/**
 * Created on 13 Jan 2019 by happygirlzt
 *
 * LeetCode #530. Minimum Absolute Difference in BST
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
// Classic In-order traversal of BST
class Solution {
    private Integer pre = null;
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return -1;
        helper(root);
        return min;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);

        if (pre != null) {
            min = Math.min(root.val - pre, min);
        }

        pre = root.val;
        helper(root.right);
    }
}
