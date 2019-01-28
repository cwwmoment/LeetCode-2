/**
 * LeetCode #450. Delete Node in a BST
 *
 * Created on 16 Sep 2018 by happygirlzt
 */

public class DeleteNodeInABST {

    // My buggy code
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        TreeNode dummy = new TreeNode(0);
            dummy.left = root;

        while (root != null) {
            if (root.val == key) {
                System.out.println("hi");
                delete(root);
                return dummy.left;
            } else if (root.val < key) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return dummy.left;
    }

    public void delete(TreeNode root) {
        if (root.left != null) {
            root.val = root.left.val;
            delete(root.left);
            root.left = null;
        }

        if (root.right != null) {
            root.val = root.right.val;
            delete(root.right);
            root.right = null;
        }
    }

    // Other's smart solution
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // Updated on 19 Jan 2019

}
