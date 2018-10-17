/**
 * LeetCode 236. Lowest Common Ancestor of a Binary Tree
 *
 * Created on 26 Aug 2018, updated on 16 Sep 2018
 *
 * @author happygirlzt
 *
 */

public class LowestCommonAncestorOfABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // conquer
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
