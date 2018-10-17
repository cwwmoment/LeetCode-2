/*
 * LeetCode #543. Diameter of Binary Tree
 * happygirlzt
 * Created on 16 Aug 2018
 */
public class DiameterofBinaryTree {
	int max;
	
	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		max = Math.max(max, left + right);
		
		return Math.max(left, right) + 1;
	}
}
