/**
 * Created on 20 Nov 2018 by happygirlzt
 *
 * LeetCode #250. Count Univalue Subtrees
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
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];

        isUni(root, res);

        return res[0];
    }


    public boolean isUni(TreeNode root, int[] res) {
        if (root == null) return true;

        boolean left = isUni(root.left, res);
        boolean right = isUni(root.right, res);

        if (left && right) {
            if (root.left != null && root.left.val != root.val) return false;
            if (root.right != null && root.right.val != root.val) return false;

            res[0]++;
            return true;
        }

        return false;
    }
}
