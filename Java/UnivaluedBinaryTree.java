/**
 * Created on 2 Jan 2019 by happygirlzt
 *
 * LeetCode #965. Univalued Binary Tree
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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.right != null) {
            return root.val == root.left.val && root.val == root.right.val && isUnivalTree(root.left) && isUnivalTree(root.right);
        }
        if (root.left != null) {
            return root.val == root.left.val && isUnivalTree(root.left);
        }
        if (root.right != null) {
            return root.val == root.right.val && isUnivalTree(root.right);
        }
        return true;
    }
}
