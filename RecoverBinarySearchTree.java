
/*
 * LeetCode #99. Recover Binary Search Tree
 * happygirlzt
 * Created on 15 Aug 2018
 * 
 */
import java.util.Stack;

public class RecoverBinarySearchTree {
	public static void recoverTree(TreeNode root) {
		if (root != null) {
			System.out.println(isBST(root));
		}
	}

	public static void exchRL(TreeNode tree) {
		int tmp = tree.val;
		tree.val = tree.left.val;
		tree.left.val = tmp;
	}

	public static void exchRR(TreeNode tree) {
		int tmp = tree.val;
		tree.val = tree.right.val;
		tree.right.val = tmp;
	}

	public static void helper(TreeNode tree) {
		Stack<TreeNode> st = new Stack<>();

		while (!st.isEmpty() || tree != null) {

			while (tree != null) {
				st.push(tree);

				if (tree.left != null && tree.val < tree.left.val) {
					exchRL(tree);
				}
				tree = tree.left;
			}

			tree = st.pop();

			if (tree.right != null && tree.val > tree.right.val) {
				exchRR(tree);
			}

			tree = tree.right;
		}

	}

	public static boolean isBST(TreeNode root)  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }
 

    public static boolean isBSTUtil(TreeNode node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (node.val < min || node.val > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.val - 1) &&
                isBSTUtil(node.right, node.val + 1, max));
    }

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left.left = null;
		tree.left.right = null;
		tree.right.left = new TreeNode(2);

		recoverTree(tree);
	}
}
