/**
 * Created on 13 Jan 2019 by happygirlzt
 *
 * LeetCode #783. Minimum Distance Between BST Nodes
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
class Solution {
    private int min = Integer.MAX_VALUE;
    private Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return -1;
        helper(root);
        return min;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);

        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }

        pre = root.val;
        helper(root.right);
    }
}
