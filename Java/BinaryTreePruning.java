/**
 * LeetCode 814. Binary Tree Pruning
 * 
 * Created by happygirlzt on 3 Sep 2018 at 10:11:39 PM
 *
 */
public class BinaryTreePruning {
	public TreeNode pruneTree(TreeNode root) {
		helper(root);
		return root;
	}

	// dfs, if root.left is leaf node and val is 0, then root.left = null
	public void helper(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null) {
			helper(root.left);
		}
		
		if (root.right != null) {
			helper(root.right);
		}
		
		if (root.left != null || root.right != null) {
			if (root.left != null && root.left.left == null && root.left.right == null && root.left.val == 0) {
				root.left = null;
			}
			if (root.right != null && root.right.left == null && root.right.right == null && root.right.val == 0) {
				root.right = null;
			}
		}
	}
	
	// Others' smart solution
	public TreeNode prune(TreeNode root) {
		if (root == null) return root;
		root.left = prune(root.left);
		root.right = prune(root.right);
		
		return (root.val == 1 || root.left != null || root.right != null) ? root : null;
	}
}
