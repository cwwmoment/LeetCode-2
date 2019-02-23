/**
 * Created on 11 Sep 2018
 *
 * LeetCode #114. Flatten Binary Tree to Linked List
 */

public class FlattenBinaryTree2LinkedList {
    /**
    public TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    */
    // Updated on 23 Feb 2019
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}
