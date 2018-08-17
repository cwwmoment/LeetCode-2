/*
 * LeetCode #98. Validate Binary Search Tree
 * happygirlzt
 * Created on 15 Aug 2018
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean helper(TreeNode root, long min, long max) {
		if (root == null)
			return true;

		if (root.val <= min || root.val >= max) {
			return false;
		}
		
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}
}
