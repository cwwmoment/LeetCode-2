/*
 * LeetCode #669. Trim a Binary Search Tree
 * happygirlzt
 * Created on 19 July 2018
 * 
 */

public class TrimABST {
	// Recursive solution
	public static TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;

		if (root.val < L) {
			return trimBST(root.right, L, R);
		}

		if (root.val > R) {
			return trimBST(root.left, L, R);
		}

		root.right = trimBST(root.right, L, R);
		root.left = trimBST(root.left, L, R);

		return root;
	}
	
	// Iterative solution
	public static TreeNode trimBST1(TreeNode root, int L, int R) {
		// Corner case
		if (root == null) return root;
		
		// Find the root
		while (root.val < L || root.val > R) {
			if (root.val < L) {
				root = root.right;
			}
			
			if (root.val > R) {
				root = root.left;
			}
		}
		
		TreeNode dummy = root;
		TreeNode tmp = root;
		// Check the left subtree
		while (dummy != null && dummy.left != null) {
			if (dummy.left.val < L) {
			    dummy.left = dummy.left.right;
			} else {
				dummy = dummy.left;
			}
		}
		
		// Check the right subtree
		while (tmp != null && tmp.right != null) {
			if (tmp.right.val > R) {
				tmp.right = tmp.right.left;
			} else {
				tmp = tmp.right;
			}
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left.left = null;
		tree.left.right = new TreeNode(2);
        tree.show(tree);
        
		TreeNode res = trimBST1(tree, 3, 4);
		res.show(tree);
	}
}
