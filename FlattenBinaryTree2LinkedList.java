/**
 * Created on 11 Sep
 *
 * LeetCode #114. Flatten Binary Tree to Linked List
 */

public class FlattenBinaryTree2LinkedList {
    public TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
