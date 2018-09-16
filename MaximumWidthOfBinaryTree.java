/**
 * LeetCode #662. Maximum Width of Binary Tree
 *
 * Created on 16 Sep 2018 by happygirlzt
 */

public class MaximumWidthOfBinaryTree {
    // a function calculates the depth
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] dep = new int[1];

        while (root.left == null && root.right != null) {
            root = root.right;
        }

        while (root.right == null && root.left != null) {
            root = root.left;
        }

        helper(root.left, dep);
        int left = dep[0] + 1;
        dep[0] = 0;
        helper(root.right, dep);
        int right = dep[0] + 1;

        int depth = Math.min(left, right);
        return (int) Math.pow(2, depth);
    }

    public void helper(TreeNode root, int[] dep) {
        if (root == null) return;

        if (root.left != null) {
            dep[0]++;
            helper(root.left, dep);
        } else if (root.left == null && root.right != null) {
            dep[0]++;
            helper(root.right, dep);
        }
    }
}
