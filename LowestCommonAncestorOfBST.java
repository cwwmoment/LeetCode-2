/*
 * LeetCode #235. Lowest Common Ancestor of a Binary Search Tree
 * happygirlzt
 * Created on 12 Aug 2018
 */
public class LowestCommonAncestorOfBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) return null;
		
		return helper(root, p, q);
	}
	
	public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		
		if (root.val > p.val && root.val > q.val) {
			return helper(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return helper(root.right, p, q);
		} else {
			return root;
		}
	}
	
	// Solution 2
	public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0) {
			root = root.val < p.val ? root.right : root.left;
		}
		
		return root;
	}
}
