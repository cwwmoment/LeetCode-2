
/*
 * LeetCode #94. Binary Tree Inorder Traversal
 * happygirlzt
 * Created on 15 Aug 2018
 */

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	
	// iterative
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<>();
		
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				res.add(root.val);
				root = root.right;
			}
		}
		
		return res;
	}
	
	// recursive
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(res, root);
		
		return res;
	}
	
	public void helper(List<Integer> res, TreeNode root) {
		if (root == null) return;
		
		helper(res, root.left);
		res.add(root.val);
		helper(res, root.right);
	}
}
