/*
 * LeetCode #700. Search in a Binary Search Tree
 * happygirlzt
 * Created on 20 July 2018
 * Updated on 17 Aug 2018
 */

public class SearchInBST {
	// Recursive solution
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return root;

		TreeNode node = new TreeNode(0);

		if (root.val == val)
			node = root;

		if (root.val < val) {
			node = searchBST(root.right, val);
		}

		if (root.val > val) {
			node = searchBST(root.left, val);
		}

		return node;
	}

	// Iterative solution
	public TreeNode searchBST1(TreeNode root, int val) {
		if (root == null || root.val == val) return root;
		
		TreeNode dummy = root;
		
		while (dummy != null) {
			if (dummy.val > val) {
				dummy = dummy.left;
			} else if (dummy.val < val) {
				dummy = dummy.right;
			} else {
				return dummy;
			}
		} 
		
		return dummy;
	}
}
