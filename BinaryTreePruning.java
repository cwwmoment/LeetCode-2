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

	public void helper(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null && root.right != null && root.val == 0) {
			
		}

		if (root.left != null) {
			helper(root.left);
		}

		if (root.right != null) {
			helper(root.right);
		}
	}
}
