/*
 * LeetCode #99. Recover Binary Search Tree
 *
 * Created by happygirlzt on 15 Aug 2018, Updated on 16 Sep 2018
 *
 */

public class RecoverBinarySearchTree {
    TreeNode pre = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        helper(root);

        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    public void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
            }

            second = root;
        }

        pre = root;

        helper(root.right);
    }
}
